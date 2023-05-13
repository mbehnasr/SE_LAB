public class Client {
    public static void main(String[] args) {
        JapaneseGardenCreator japaneseGardenCreator =  new FactoryCreator().createJapaneseGardenCreator();
        JapaneseTree japaneseTree =  japaneseGardenCreator.createTree();

        System.out.println(japaneseTree.maxAge);


    }
}
