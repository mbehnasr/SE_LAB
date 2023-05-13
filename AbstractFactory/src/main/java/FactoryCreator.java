public class FactoryCreator {
    IranianGardenCreator createIranianGardenCreator(){
        System.out.println("Iranian garden created.");
        return new IranianGardenCreator();
    }

    JapaneseGardenCreator createJapaneseGardenCreator(){
        System.out.println("Japanese garden created.");
        return new JapaneseGardenCreator();
    }
}
