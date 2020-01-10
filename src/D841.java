import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * 钥匙和房间
 *
 * @author luliuquan
 * @date 2020年1月10日
 */
public class D841 {
    public static void main(String[] args) {
        Path path = Paths.get(".\\in\\" + D841.class.getSimpleName());
        try {
            List<String> lines = Files.readAllLines(path);
            for (String line : lines) {
                ObjectMapper objectMapper = new ObjectMapper();
                List<List<Integer>> in = objectMapper.readValue(line, new TypeReference<List<List<Integer>>>() {
                });
                new SolutionWarp().canVisitAllRooms(in);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class SolutionWarp extends Solution {
        @Override
        public boolean canVisitAllRooms(List<List<Integer>> rooms) {
            long start = System.currentTimeMillis();
            boolean result = super.canVisitAllRooms(rooms);
            long end = System.currentTimeMillis();
            System.out.printf("rooms: %s %n", rooms);
            System.out.printf("time: %s result: %s%n", (end - start), result);
            return result;
        }
    }

    /**
     * 直接求解。
     */
    static
    class Solution {
        public boolean canVisitAllRooms(List<List<Integer>> rooms) {
            int[] opened2 = new int[rooms.size()];
            opened2[0] = 1;
            int openedLength = 1;
            int[] keys = new int[3000];
            int keyLength = 0;
            for (Integer key : rooms.get(0)) {
                keys[keyLength++] = key;
            }
            while (keyLength != 0) {
                if (openedLength == rooms.size()) {
                    return true;
                }
                int nextRoom = keys[--keyLength];
                if (opened2[nextRoom] == 1) {
                    continue;
                }
                opened2[nextRoom] = 1;
                openedLength++;
                for(Integer key : rooms.get(nextRoom)) {
                    if (opened2[key] == 1) {
                        continue;
                    }
                    keys[keyLength++] = key;
                }
            }
            return openedLength == rooms.size();
        }
    }
}