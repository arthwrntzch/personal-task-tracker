import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class TaskManager {
    public static void main(String[] args) {
        ArrayList<Task> taskList = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        while (true) { 
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            menu(choice);
            break;   
        }
    }

    private static void showMenu(){
        System.out.println("1 - Добавить задачу\n2 - Удалить задачу\n3 - Изменить задачу\n4 - Посмотреть все задачи\n5 - Выход из программы");
    }

    private static void menu(int choice){
        switch(choice){
            case 1: addTask(); break;
            case 2: removeTask(); break;
            case 3: editTask(); break;
            case 4: showAllTask(); break;
            case 5: System.out.println("Выход из программы"); break;
            default: System.out.println("Вы ввели некорректное значение. Попробуйте снова");
        }
    }

    private static void addTask(){
        System.out.println("Добавление задачи");
    }
    private static void removeTask(){
        System.out.println("Удаление задачи");
    }
    private static void editTask(){
        System.out.println("Изменение задачи");
    }
    private static void showAllTask(){
        System.out.println("Показ задач");
    }
}     

class Task{
    private String name;
    private String description;
    private String status;
    private LocalDate duDate;


    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return this.status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getDuDate() {
        return this.duDate;
    }

    public void setDuDate(LocalDate duDate) {
        this.duDate = duDate;
    }

}
