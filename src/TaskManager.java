package src;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class TaskManager {
    private static ArrayList<Task> taskList = new ArrayList<>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        while (true) { 
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine();
            menu(choice); 
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
            case 4: showAllTasks(); break;
            case 5: 
                System.out.println("Выход из программы");
                System.exit(0);
                break;
            default: 
                System.out.println("Вы ввели некорректное значение. Попробуйте снова\n");
        }
    }

    private static void addTask(){
        System.out.println("Добавление задачи");
        String name;
        String description;
        String status;
        LocalDate dueDate = null;

        System.out.print("Введите название задачи: ");
        name = scanner.nextLine();

        System.out.print("Введите описание задачи: ");
        description = scanner.nextLine();

        System.out.print("Введите статус задачи: ");
        status = scanner.nextLine();

        System.out.print("Пожалуйста, используйте формат yyyy-MM-dd\nВведите дедлайн задачи: ");
        while (dueDate == null) {
            System.out.print("Введите дедлайн задачи (формат yyyy-MM-dd): ");
            String dateInput = scanner.nextLine();
            try {
                dueDate = LocalDate.parse(dateInput);
            } catch (DateTimeParseException e) {
                System.out.println("Некорректный формат даты. Пожалуйста, используйте формат yyyy-MM-dd.");
            }
        }
                        
        Task task = new Task(name, description, status, dueDate);
        taskList.add(task);
        System.out.println("Задача успешно добавлена.");
    }

    private static void removeTask(){
        System.out.println("Удаление задачи");
        showAllTasks();
        System.out.print("Введите номер задачи для удаления: ");
        int choice = scanner.nextInt() - 1;
        scanner.nextLine();
        if (choice >= 0 && choice < taskList.size()) {
            taskList.remove(choice);  
            System.out.println("Задача была успешно удалена.");
        } else {
            System.out.println("Удалить не получилось. Попробуйте снова.");
        }
    }

    private static void showEdit(){
        System.out.println("1 - Изменить имя задачи\n2 - Изменить описание задачи\n3 - Изменить статус задачи\n4 - Изменить дату задачи\n5 - Ничего не менять");
    }

    private static void editTask(){
        System.out.println("Изменение задачи\nВыберите из списка задачу, которую хотите изменить:");
        showAllTasks();
        System.out.print("Введите номер задачи для изменения: ");
        int choice = scanner.nextInt() - 1;
        if (choice >= 0 && choice < taskList.size()) {
            Task task = taskList.get(choice);
            scanner.nextLine();
            showEdit();
            System.out.print("Введите номер действия: ");
            int editChoice = scanner.nextInt();
            scanner.nextLine();
            switch (editChoice) {
                case 1:
                    System.out.print("Введите новое имя задачи: ");
                    String newName = scanner.nextLine();
                    task.setName(newName);
                    System.out.println("Имя задачи обновлено.");
                    break;
                case 2:
                    System.out.print("Введите новое описание задачи: ");
                    String newDescription = scanner.nextLine();
                    task.setDescription(newDescription);
                    System.out.println("Описание задачи обновлено.");
                    break;
                case 3:
                    System.out.print("Введите новый статус задачи: ");
                    String newStatus = scanner.nextLine();
                    task.setStatus(newStatus);
                    System.out.println("Статус задачи обновлен.");
                    break;
                case 4:
                    LocalDate dueDate = null;
                    while (dueDate == null) {
                        System.out.print("Введите дедлайн задачи (формат yyyy-MM-dd): ");
                        String dateInput = scanner.nextLine();
                        try {
                            dueDate = LocalDate.parse(dateInput);
                            task.setDueDate(dueDate);
                            System.out.println("Дата задачи обновлена.");
                        } catch (DateTimeParseException e) {
                            System.out.println("Некорректный формат даты. Пожалуйста, используйте формат yyyy-MM-dd.");
                        }
                    }
                    break;
                case 5:
                    System.out.println("Изменения не внесены.");
                    break;
                default:
                    System.out.println("Некорректный выбор.");
                    break;
            }
        } else {
            System.out.println("Задача с таким номером не найдена.");
        }
    }
    
    private static void showAllTasks() {
        System.out.println("Список задач:");
        System.out.printf("%-5s %-20s %-30s %-10s %-15s%n", "№", "Название", "Описание", "Статус", "Срок");
        System.out.println("---------------------------------------------------------------------");
    
        for (int i = 0; i < taskList.size(); i++) {
            Task task = taskList.get(i);
            System.out.printf("%-5d %-20s %-30s %-10s %-15s%n",
                    i + 1,
                    task.getName(),
                    task.getDescription(),
                    task.getStatus(),
                    task.getDueDate());
        }
    }
}     

class Task {
    private String name;
    private String description;
    private String status;
    private LocalDate dueDate;

    public Task(String name, String description, String status, LocalDate date) {
        this.name = name;
        this.description = description;
        this.status = status;
        this.dueDate = date;
    }

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

    public LocalDate getDueDate() {
        return this.dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "name='" + getName() + "'" +
               ", description='" + getDescription() + "'" +
               ", status='" + getStatus() + "'" +
               ", dueDate='" + getDueDate() + "'";
    }
}
