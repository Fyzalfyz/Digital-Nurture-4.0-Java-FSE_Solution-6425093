package DataStructureAndAlgorthms;
class Task {
    String id;
    String name;
    String status;
    Task next;

    Task(String id, String name, String status) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.next = null;
    }

    void show() {
        System.out.println(id + " | " + name + " | " + status);
    }
}

public class TaskList {
    Task head = null;

    void add(String id, String name, String status) {
        Task t = new Task(id, name, status);
        if (head == null) {
            head = t;
        } else {
            Task curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = t;
        }
    }

    void viewAll() {
        Task curr = head;
        while (curr != null) {
            curr.show();
            curr = curr.next;
        }
    }

    void find(String id) {
        Task curr = head;
        while (curr != null) {
            if (curr.id.equals(id)) {
                curr.show();
                return;
            }
            curr = curr.next;
        }
        System.out.println("Task not found");
    }

    void remove(String id) {
        if (head == null) return;

        if (head.id.equals(id)) {
            head = head.next;
            return;
        }

        Task curr = head;
        while (curr.next != null) {
            if (curr.next.id.equals(id)) {
                curr.next = curr.next.next;
                return;
            }
            curr = curr.next;
        }
        System.out.println("Task not found to remove");
    }

    public static void main(String[] args) {
        TaskList tasks = new TaskList();

        tasks.add("Task 1", "Submit DSA Assignment", "Pending");
        tasks.add("Task 2", "Complete Java Project", "In Progress");
        tasks.add("Task 3", "Database PPT Prep", "Pending");
        tasks.add("Task 4", "Cloud Lab Writeup", "Completed");
        tasks.add("Task 5", "AI Paper Submission", "Pending");

        System.out.println("All Tasks:");
        tasks.viewAll();

        System.out.println("\nSearch for Item 3:");
        tasks.find("Task 3");

        System.out.println("\nRemoving Item 2:");
        tasks.remove("Task 2");

        System.out.println("\nUpdated Task List:");
        tasks.viewAll();
    }
}

