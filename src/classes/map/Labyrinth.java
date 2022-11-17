package classes.map;

import java.io.*;

import static classes.algorithm.PathFindingAlgorithm.getMapWithShortestPath;
import static classes.tools.MessagesEditor.joinArrays;
import static classes.tools.MessagesEditor.printInInformationFrame;

public class Labyrinth {

    private final String path = "maps/";
    public char[][] maze;

    public Labyrinth() {
    }

    public void showMap() {
        String[] mapData = generateArrayFromMap(maze);
        printInInformationFrame(joinArrays(new String[]{"Map:"}, mapData));
    }

    public void showMap(char[][] map, String[] messages) {
        String[] mapData = generateArrayFromMap(map);
        printInInformationFrame(joinArrays(messages, mapData));
    }

    public String[] generateArrayFromMap(char[][] map) {
        String[] mapData = new String[map.length];
        for (int i = 0 ; i < map.length; i++) {
            StringBuilder row = new StringBuilder();
            for(int g = 0 ; g < map[i].length ; g++){
                row.append(map[i][g]);
            }
            mapData[i] = row.toString();
        }
        return mapData;
    }

    public void showShortestPath() {
        char[][] map = getMapWithShortestPath(Utility.deepCopy(this.maze));
        showMap(map, new String[]{"The shortest path:"});
    }

    public String[] getMapNames() {
        File directory = new File(path);
        MyFilenameFilter filter = new MyFilenameFilter(".txt");
        String[] list = directory.list(filter);
        if (list == null) {
            printInInformationFrame(new String[]{
                    "Empty directory or directory does not exists.",
                    "Please, load txt file map first."});
            System.exit(0);
        }
        return list;
    }

    public void convert(String fileName){
        File file = new File(path + fileName);
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;
            String[] values;

            int rows = 0;
            int cols = 0;
            while ((st = br.readLine()) != null) {
                if(cols == 0){
                    cols = st.length();
                }
                rows++;
            }
            br = new BufferedReader(new FileReader(file));

            this.maze = new char[rows][cols];
            int[] coordinates = {0,0};
            while ((st = br.readLine()) != null){
                values = st.split("");
                for(String v : values){
                    this.maze[coordinates[0]][coordinates[1]] = v.charAt(0);
                    coordinates[1]++;
                }
                coordinates[0]++;
                coordinates[1] = 0;
            }
            this.maze[1][0] = '■';
        } catch (IOException e) {
            printInInformationFrame(new String[]{"Exception"});
        }
    }

    static class MyFilenameFilter implements FilenameFilter {

        String initials;

        public MyFilenameFilter(String initials)
        {
            this.initials = initials;
        }
        
        public boolean accept(File dir, String name)
        {
            return name.endsWith(initials);
        }

    }

}
