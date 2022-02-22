import java.util.Scanner;
public class MovieDriver {

	public static void main(String[] args) {
		
		Scanner keyboard = new Scanner(System.in);
		char response = 'y';
		
		while(response == 'y')
		{
			Movie obj = new Movie();
			System.out.println("Enter the title of a movie: ");
			String title = keyboard.nextLine();
			obj.setTitle(title);
			System.out.println("Enter the movie's rating: ");
			String rating = keyboard.next();
			obj.setRating(rating);
			System.out.println("Enter the number of tickets sold at a theater: ");
			int tickets = keyboard.nextInt();
			obj.setSoldTickets(tickets);
			System.out.println(obj.toString());
			System.out.println("Do you want to enter another? (y or n)");
			response = keyboard.next().charAt(0);
			keyboard.nextLine();
		}
		
		System.out.println("Goodbye!");
	
	}

}
