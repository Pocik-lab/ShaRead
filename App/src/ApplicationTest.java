import java.util.Scanner;

import static org.junit.Assert.*;

public class ApplicationTest {

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @BeforeClass
    public static void globalSetUp(){
        System.out.println("Initial...");
    }

    @Before
    public void setUp(){
        System.out.println("Set up before testing");
    }

    @Test
    public void whenAddNewAnnotationThenAddToAnnotations() throws Exception{
        assertEquals(AnnotationsWindow.annotations.size(), 0);
        AnnotationsWindow.annotations.add(new BookAnnotation("test", "test"));
        assertEquals(AnnotationsWindow.annotations.size(), 1);
    }

    @Test
    public void whenAddNewBookThenAddToBooks() throws Exception{
        assertEquals(BooksWindow.books.size(), 0);
        BooksWindow.books.add(new Book("testName","Author", new ArrayList<>()));
        assertEquals(BooksWindow.books.size(), 1);
    }

    @Test
    public void savingBooksIsCorrect() throws Exception{
        boolean isCorrect = Loader.saveBooks();
        assertTrue(isCorrect);
    }

    @Test
    public void savingAnnotationsIsCorrect() throws Exception{
        boolean isCorrect = Loader.saveAnnotation();
        assertTrue(isCorrect);
    }

    @Test
    public void loadingBooksIsCorrect() throws Exception{
        Boolean isCorrect = Loader.loadListBook();
        assertTrue(isCorrect);
    }

    @Test
    public void loadingAnnotationsIsCorrect() throws Exception{
        Boolean isCorrect = Loader.loadListAnnotation();
        assertTrue(isCorrect);
    }

    @Test
    public void countingPages() throws Exception{
        ArrayList<String> pages = new ArrayList<String>();
        pages.add("qwertyu");
        pages.add("qwertyu");
        BooksWindow.books.add(new Book("testName","Author", pages));
        System.out.println(BooksWindow.books.get(0).countPage());
        assertEquals(BooksWindow.books.get(BooksWindow.books.size()-1).countPage(),2);
    }

    @Test
    public void correctMenuVisible() throws Exception{
        Controller controller = new Controller();
        ByteArrayInputStream in = new ByteArrayInputStream("m".getBytes());
        Controller.sc = new Scanner(in);
        controller.menuInput();
        assertTrue(!Controller.window.menu.isActive);
    }

    @Test
    public void intIsCorrect() throws Exception{
        Controller controller = new Controller();
        ByteArrayInputStream in = new ByteArrayInputStream("5".getBytes());
        Scanner sc = new Scanner(in);
        String str = sc.nextLine();
        assertTrue(controller.isInt(str));
    }

    @Test
    public void intIsNotCorrect() throws Exception{
        Controller controller = new Controller();
        ByteArrayInputStream in = new ByteArrayInputStream("a".getBytes());
        Scanner sc = new Scanner(in);
        String str = sc.nextLine();
        assertTrue(!controller.isInt(str));
    }

    @Test
    public void correctExit() throws Exception{
        Controller controller = new Controller();
        ByteArrayInputStream first = new ByteArrayInputStream("m\n0".getBytes());
        Controller.sc = new Scanner(first);
        controller.start();
        assertTrue(controller.getExit());
    }

    @Test
    public void correctAunt() throws Exception{
        Controller controller = new Controller();
        ByteArrayInputStream in = new ByteArrayInputStream("mama".getBytes());
        controller.sc = new Scanner(in);
        assertTrue(Authentication.enter());
    }

    @Test
    public void correctMain() throws Exception{
        Controller controller = new Controller();
        controller.menu = new Menu("child");
        controller.window = new BooksWindow("Books", "Книги", controller.menu);
        Window window = controller.menu.createWindow(Controller.window,Integer.parseInt("3"));
        assertEquals(window.getClass().getName(),"com.company.AnnotationsWindow");
    }

    @Test
    public void correctAbout() throws Exception{
        Controller controller = new Controller();
        ByteArrayInputStream first = new ByteArrayInputStream("m\n8\nm\n0".getBytes());
        Controller.sc = new Scanner(first);
        controller.start();
        assertTrue(controller.getExit());
    }

    @Test
    public void correctAnnotationWindow() throws Exception{
        Controller controller = new Controller();
        ByteArrayInputStream first = new ByteArrayInputStream("m\n3\nm\n0".getBytes());
        Controller.sc = new Scanner(first);
        controller.start();
        assertTrue(controller.getExit());
    }

    @Test
    public void correctAnnotation() throws Exception{
        Controller controller = new Controller();
        AnnotationsWindow.annotations.add(new BookAnnotation("test", "test"));
        ByteArrayInputStream first = new ByteArrayInputStream("m\n3\nf\ntest\nm\n0".getBytes());
        Controller.sc = new Scanner(first);
        controller.start();
        assertTrue(controller.getExit());
    }

    @Test
    public void correctBook() throws Exception{
        Controller controller = new Controller();
        ArrayList<String> pages = new ArrayList<String>();
        pages.add("qwertyu");
        pages.add("qwertyu");
        BooksWindow.books.add(new Book("testName","Author", pages));
        ByteArrayInputStream first = new ByteArrayInputStream("m\n2\nf\ntestName\nm\n0".getBytes());
        Controller.sc = new Scanner(first);
        controller.start();
        assertTrue(controller.getExit());
    }

    @Test
    public void correctBookDeleting() throws Exception{
        Controller controller = new Controller();
        ArrayList<String> pages = new ArrayList<String>();
        pages.add("qwertyu");
        pages.add("qwertyu");
        BooksWindow.books.add(new Book("testName","Author", pages));
        ByteArrayInputStream first = new ByteArrayInputStream("m\n7\nmama\nm\n2\nd\ntestName\nm\n0".getBytes());
        Controller.sc = new Scanner(first);
        controller.start();
        assertTrue(controller.getExit());
    }

    @Test
    public void correctBookAdd() throws Exception{
        Controller controller = new Controller();
        ByteArrayInputStream first = new ByteArrayInputStream("e\naboba\nm\n0".getBytes());
        Controller.sc = new Scanner(first);
        controller.start();
        assertTrue(controller.getExit());
    }

    @Test
    public void correctProgress() throws Exception{
        Controller controller = new Controller();
        ByteArrayInputStream first = new ByteArrayInputStream("m\n5\nm\n0".getBytes());
        Controller.sc = new Scanner(first);
        controller.start();
        assertTrue(controller.getExit());
    }

    @Test
    public void correctTask() throws Exception{
        Controller controller = new Controller();
        ByteArrayInputStream first = new ByteArrayInputStream("m\n4\nm\n0".getBytes());
        Controller.sc = new Scanner(first);
        controller.start();
        assertTrue(controller.getExit());
    }

    @Test
    public void changePageOfBook() throws Exception{
        Controller controller = new Controller();
        ArrayList<String> pages = new ArrayList<String>();
        pages.add("qwertyu");
        pages.add("qwertyu");
        BooksWindow.books.add(new Book("testName","Author", pages));
        ByteArrayInputStream first = new ByteArrayInputStream("f\ntestName\nn\nm\n0".getBytes());
        Controller.sc = new Scanner(first);
        controller.start();
        assertTrue(controller.getExit());
    }

    @Test
    public void correctAchiv() throws Exception{
        Controller controller = new Controller();
        ByteArrayInputStream first = new ByteArrayInputStream("m\n6\nm\n0".getBytes());
        Controller.sc = new Scanner(first);
        controller.start();
        assertTrue(controller.getExit());
    }

    @AfterClass
    public static void tearDown() {
        System.out.println("Tests finished");
    }

    @After
    public void afterMethod() {
        System.out.println("Code executes after each test method");
    }
}
