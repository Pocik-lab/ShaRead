package com.company;

public class AnnotationWindow extends Window{
    BookAnnotation curAnnotation;
    Boolean isWriting;

    AnnotationWindow(String name, String title, Menu menu, BookAnnotation curAnnotation, boolean isWriting){
        super(name, title, menu);
        this.curAnnotation = curAnnotation;
        this.isWriting = isWriting;
    }

    @Override
    public void display() {
        if(isWriting){
            if(curAnnotation.name.equals("")){
                System.out.println("\nВведите название аннотации: ");
            }
            else{
                System.out.println("\nЧтобы завершить ввод нажмите ENTER 2 раза.");
                System.out.println("Пишите аннотацию:");
            }
        }
        else {
            curAnnotation.display();
            System.out.println("===============================\n");
            System.out.println("Вернуться к списку аннотаций - b");
            super.display();
        }
    }

    @Override
    public void save() {
    }

    @Override
    public void input(){
        if(!isWriting){
            String inp = Controller.sc.nextLine();
            if(inp.equals("m")){
                this.save();
                menu.isActive = true;
            }else if(inp.equals("b")) {
                Controller.window = new AnnotationsWindow("Annotations", "Аннотации", menu);
                Controller.window.display();
            } else {
                System.out.println("Такой команды нет!\n");
                Controller.window.display();
            }
        }
        else {
            if(curAnnotation.name.equals("")) curAnnotation.name = Controller.sc.nextLine();
            else if(curAnnotation.text.equals("")) {
                display();
                curAnnotation.text = "";
                while(true){
                    String current = Controller.sc.nextLine();
                    if(current.equals(""))break;
                    curAnnotation.text = String.join("\n",curAnnotation.text ,current);
                }
            }
            else {
                Controller.window = new AnnotationsWindow("Annotations", "Аннотации", menu);
                Controller.window.display();
            }
        }
    }
}
