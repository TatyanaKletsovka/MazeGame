package classes.algorithm;

import java.util.*;

public class PathFindingAlgorithm {

    private static void addRoadToMap(char[][] map, List<int[]> road) {
        for (int[] coordinates : road) {
            map[coordinates[0]][coordinates[1]] = '■';
        }
    }

    public static char[][] getMapWithShortestPath(char[][] map) {
        int[] nearestExitCoordinates = findNearestExit(map);
        map[nearestExitCoordinates[0]][nearestExitCoordinates[1]] = 'D';
        List<int[]> road = PathFindingAlgorithm.getShortestPathCoordinates(map);
        PathFindingAlgorithm.addRoadToMap(map, road);
        return map;
    }

    private static List<int[]> findExits(char[][] map) {
        List<int[]> coordinates = new ArrayList<>();
        //up
        for(int i = 0; i < map[0].length; i++){
            if(map[0][i] == '-' || map[0][i] == '@'){
                coordinates.add(new int[]{0, i});
            }
        }
        //right
        for(int i = 0; i < map.length; i++){
            int lastIndex = map[0].length -1;
            if(map[i][lastIndex] == '-' || map[i][lastIndex] == '@'){
                coordinates.add(new int[]{i, lastIndex});
            }
        }
        //down
        for(int i = 0; i < map[0].length; i++){
            int rowLastIndex = map.length - 1;
            if(map[rowLastIndex][i] == '-' || map[rowLastIndex][i] == '@'){
                coordinates.add(new int[]{rowLastIndex, i});
            }
        }
        //left
        for(int i = 0; i < map.length; i++){
            if(map[i][0] == '-' || map[i][0] == '@'){
                if(i != 1){
                    coordinates.add(new int[]{i, 0});
                }

            }
        }
        return coordinates;
    }

    private static int[] findNearestExit(char[][] map){
        List<int[]> coordinates = findExits(map);
        int min = 0;
        int[] minCoordinates = new int[]{0};
        char oldValue;
        for(int[] c : coordinates){
            oldValue = map[c[0]][c[1]];
            map[c[0]][c[1]] = 'D';
            int pathValue = getShortestPathCoordinates(map).size();
            if(min == 0){
                min = pathValue;
                minCoordinates = c;
            }else if(min > pathValue){
                min = pathValue;
                minCoordinates = c;
            }
            map[c[0]][c[1]] = oldValue;
        }
        return minCoordinates;
    }

    private static void findPathWithAlgorithm(char[][] grid, Cello start, List<int[]> path) {
        int[] xDirs = new int[]{0, 0, 1, -1};
        int[] yDirs = new int[]{1, -1, 0, 0};
        Queue<Cello> bfsQueue = new LinkedList<>();
        bfsQueue.add(start);
        HashMap<Cello, Cello> parentMap = new HashMap<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Cello endCell = null;
        while (!bfsQueue.isEmpty()) {
            boolean flag = false;
            Cello from = bfsQueue.poll();

            for (int k = 0; k < xDirs.length; ++k) {
                int nextX = from.row + xDirs[k];
                int nextY = from.col + yDirs[k];

                if (nextX < 0 || nextX >= grid.length || nextY < 0
                        || nextY >= grid[0].length || grid[nextX][nextY] == 'x'
                        || visited[nextX][nextY]) {
                    continue;
                }

                visited[nextX][nextY] = true;
                Cello nextCell = new Cello(nextX, nextY);
                bfsQueue.add(nextCell);
                parentMap.put(nextCell, from);
                if (grid[nextX][nextY] == 'D') {
                    endCell = new Cello(nextX, nextY);
                    flag = true;
                    break;
                }
            }
            if (flag) {
                break;
            }
        }
        Stack<Cello> stack = new Stack<>();
        stack.push(endCell);
        while (true) {
            Cello fromCell = parentMap.get(endCell);
            stack.push(fromCell);
            if (fromCell == start) break;
            endCell = fromCell;
        }
        while (!stack.isEmpty()) {
            Cello p = stack.pop();
            path.add(new int[]{p.row, p.col});
        }
    }

    private static List<int[]> getShortestPathCoordinates(char[][] grid) {
        ArrayList<int[]> path = new ArrayList<>();
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == '■') {
                    findPathWithAlgorithm(grid, new Cello(i, j), path);
                }
            }
        }
        return path;
    }
}
