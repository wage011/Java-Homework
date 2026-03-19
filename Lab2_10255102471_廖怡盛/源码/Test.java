public class Test{
    public static void main(String[] args) {
        String fileName = "test.txt";

        System.out.println("=== 1. 开始写入文件 ===");
        FileIO.writeStringToFile("《老人与海》是海明威创作的中篇小说，首次出版于1952年。\n", fileName);
        FileIO.writeStringToFile("故事讲述了一位老渔夫圣地亚哥在海上与一条巨大的马林鱼搏斗的经历。\n", fileName);
        FileIO.writeStringToFile("The novel The Old Man and the Sea is based on a real story. After the end of world war I, Hemingway moved to Cuba, where\n", fileName);
        FileIO.writeStringToFile("in 1930, Hemingway was rescued by Fontes when his boat sank in a storm. From then on, Hemingway and Fontes formed a c\n", fileName);
        System.out.println("写入完成。");

        System.out.println("\n=== 2. 读取第5个字符 ===");
        char c = FileIO.getCharFromFile(5, fileName);
        System.out.println("第5个字符是: " + c);

        System.out.println("\n=== 3. 读取第3行 ===");
        String line3 = FileIO.getLineFromFile(2, fileName);
        System.out.println("第3行内容是: " + line3);

        System.out.println("\n=== 4. 读取所有行 ===");
        String[] allLines = FileIO.getAllLinesFromFile(fileName);
        System.out.println("文件所有行内容：");
        for (int i = 0; i < allLines.length; i++) {
            System.out.println("第 " + (i+1) + " 行: " + allLines[i]);
        }
    }
}