import java.util.ArrayList;

public class Test {
    private static double testMap(Map<String, Integer> map, String fileName) {
        String mapClass = map.getClass().toString();
        long start = System.nanoTime();

        System.out.println(fileName);
        ArrayList<String> words = new ArrayList<>();
        if(FileOperation.readFile(fileName, words)) {
            System.out.println("Total words: " + words.size());
            for(String word : words) {
                if(map.contains(word)) {
                    map.set(word, map.get(word) + 1);
                }else{
                    map.add(word, 1);
                }
            }

            System.out.println("[" + mapClass + "]" + " Total different words: " + map.getSize());
            System.out.println("[" + mapClass + "]" +" Frequency of PRIDE: " + map.get("pride"));
            System.out.println("[" + mapClass + "]" +" Frequency of PREJUDICE: " + map.get("prejudice"));
        }

        long end = System.nanoTime();

        return (end - start) / 1000000000.0;
    }

    public static void main(String[] args) {
        String fileName = "Map/pride-and-prejudice.txt";
        double linkedListMapTime = Test.testMap(new LinkedListMap<String, Integer>(), fileName);
        double BSTMapTime = Test.testMap(new BSTMap<String, Integer>(), fileName);
        System.out.println("LinkedListMap time: " + linkedListMapTime);
        System.out.println("BSTMap time: " + BSTMapTime);
    }
}
