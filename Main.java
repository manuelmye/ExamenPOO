import data.itemsData;
import items.items;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ItemsData itemsData = new ItemsData();
        boolean var = true;
        while (var) {
            System.out.println("1.- List\n" +
                    "2.- Create\n" +
                    "3.- Get\n" +
                    "4.- Update\n" +
                    "5.- Remove\n" +
                    "6.- Exit\n");
            System.out.print("Enter: ");
            String option = sc.nextLine();
            switch (option) {
                case 1:
                    for (Items items: itemsData.list()) {
                        System.out.println(items.getId() + "\t" + items.getNombre() + "\t" + items.getCategoria() + "\t" + items.getFamilia() + "\t" + items.getPrecio());
                    }
                    System.out.println("");
                    break;
                case 2:
                    Items items = new Items();
                    System.out.print("Enter name: ");
                    items.setNombre(sc.nextLine());
                    System.out.print("Enter category: ");
                    items.setCategoria(sc.nextLine());
                    System.out.print("Enter price: ");
                    try {
                        items.setPrecio(sc.nextInt());
                        sc.nextLine();
                    } catch (Exception e) {
                        sc.nextLine();
                        System.out.print("The price Integer");
                    }
                    itemsData.create(items);
                    break;
                case 3:
                    System.out.print("Enter the id: ");
                    int id = sc.nextInt();
                    Items items1 = itemsData.get(id);
                    System.out.println(items1.getId() + "\t" + items1.getNombre() + "\t" + items1.getCategoria() + "\t" + items1.getFamilia() + "\t" + items1.getPrecio());
                    sc.nextLine();
                    break;
                case 4:
                    System.out.print("Enter the id: ");
                    Items items2 = itemsData.get(sc.nextInt());
                    if (items2 != null) {
                        sc.nextLine();
                        System.out.print("Enter name: ");
                        items2.setNombre(sc.nextLine());
                        System.out.print("Enter category: ");
                        items2.setCategoria(sc.nextLine());
                        System.out.print("Enter price: ");
                        try {
                            items2.setPrecio(sc.nextInt());
                            sc.nextLine();
                        } catch (Exception e) {
                            sc.nextLine();
                            System.out.print("The price Integer");
                        }
                        itemsData.update(items2);
                    } else {
                        System.out.println("Not results");
                    }
                    break;
                case 5:
                    System.out.print("Enter remove: ");
                    itemsData.delete(sc.nextInt());
                    System.out.println("The delete successfully!");
                    sc.nextLine();
                    break;
                case 6:
                    var = null;
                    break;
            }
        }
    }
}
