import javax.swing.JFrame;
import javax.swing.UIManager;

public class App {

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			System.out.println("Erro ao configurar a aparência da aplicação: " + e);
		}
		
		JFrame framePrincipal = new JFrame();
		
		framePrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		framePrincipal.setSize(600, 400);
		framePrincipal.setVisible(true);
	}

}
