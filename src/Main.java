public class Main {
    public static void main(String[] args) {
        FileNavigator fileNavigator = new FileNavigator() {
            {
                add(new FileData("report.docx", "C:/Users/JohnDoe/Documents/Work/Project1"), "C:/Users/JohnDoe/Documents/Work/Project1");
                add(new FileData("budget.xlsx", "C:/Users/JohnDoe/Documents/Work/Project2"), "C:/Users/JohnDoe/Documents/Work/Project1");
                add(new FileData("invoice.pdf", "C:/Users/JohnDoe/Documents/Work/Project1"), "C:/Users/JohnDoe/Documents/Work/Project2");
                add(new FileData("data.csv", "C:/Users/JohnDoe/Documents/Work/Project1"), "C:/Users/JohnDoe/Documents/Work/Project1");
                add(new FileData("image.jpg", "/D:/Photos/Vacation/2022/"), "/D:/Photos/Vacation/2022/");
                add(new FileData("vid1488.mp4", "/D:/Photos/Vacation/2022/"), "/D:/Photos/Vacation/2022/");
                add(new FileData("vid2023.mp4", "/D:/Photos/Vacation/2022/"), "/D:/Photos/Vacation/2022/");
                add(new FileData("music.mp3", "E:/Music/Favorites"), "E:/Music/Favorites");
                add(new FileData("ksusha", "E:/Music/Favorites"), "E:/Music/Favorites");
                add(new FileData("code.java", "E:/Music/Favorites"), "E:/Music/Favorites");
                add(new FileData("presentation.pptx", "E:/Music/Favoritesss"), "E:/Music/Favorites");
            }
        };

        fileNavigator.printAll();

        System.out.println(fileNavigator.filterBySize(20000000));
        System.out.println(fileNavigator.sortBySize());

        System.out.println(fileNavigator.find("E:/Music/Favorites"));
        fileNavigator.remove("E:/Music/Favorites");
        fileNavigator.remove("C:/Users/JohnDoe/Documents/Work/Project1");

        fileNavigator.printAll();


    }
}