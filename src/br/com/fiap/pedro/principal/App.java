package br.com.fiap.pedro.principal;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.Arrays;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.UIManager;

import br.com.fiap.pedro.componentes.BotaoListener;
import br.com.fiap.pedro.componentes.MeuCheckBox;
import br.com.fiap.pedro.componentes.MeuComboBox;
import br.com.fiap.pedro.componentes.MeuLabel;
import br.com.fiap.pedro.componentes.MeuRadioGroup;
import br.com.fiap.pedro.componentes.MeuTextArea;
import br.com.fiap.pedro.componentes.MeuTextField;
import br.com.fiap.pedro.util.Paleta;
import br.com.fiap.pedro.util.StarRater;

public class App {

	private static final String PATH_POSTER_ILHA_DO_MEDO = "src/posterIlhaDoMedo.jpg";

	public static void main(String[] args) {
		configurarAparencia();

		JFrame framePrincipal = new JFrame("FIAP Movies");

		JTabbedPane abas = new JTabbedPane();

		JPanel painelCadastro = new JPanel();
		painelCadastro.setLayout(new GridLayout(1, 3));

		JPanel painelPoster = new JPanel();
		painelPoster.setLayout(new FlowLayout());
		painelCadastro.add(painelPoster);

		JPanel painelDados = new JPanel();
		painelDados.setLayout(new FlowLayout(FlowLayout.LEFT));

		JPanel painelClassificacao = new JPanel();
		painelClassificacao.setLayout(new FlowLayout(FlowLayout.LEFT));

		painelPoster.add(new JLabel(new ImageIcon(PATH_POSTER_ILHA_DO_MEDO)));

		painelDados.add(new MeuLabel("Título:"));
		MeuTextField fieldTitulo = new MeuTextField();
		painelDados.add(fieldTitulo);

		painelDados.add(new MeuLabel("Sinopse:"));
		MeuTextArea fieldSinopse = new MeuTextArea();
		painelDados.add(fieldSinopse);

		painelDados.add(new MeuLabel("Gênero:"));
		String[] generos = { "", "Terror", "Drama", "Ação", "Infantil", "Comédia", "Aventura", "Documentário",
				"Romance" };
		MeuComboBox comboGeneros = new MeuComboBox(generos);
		painelDados.add(comboGeneros);

		MeuLabel labelOndeAssistir = new MeuLabel("Onde assistir:");
		labelOndeAssistir.setLayout(new GridLayout(1, 2));
		painelClassificacao.add(labelOndeAssistir);
		MeuRadioGroup radioOndeAssistir = new MeuRadioGroup(Arrays.asList("Netflix", "Prime Video", "Pirate Bay"));
		radioOndeAssistir.setLayout(new GridLayout(3, 1));
		painelClassificacao.add(radioOndeAssistir);

		JPanel painelAssistido = new JPanel();
		painelAssistido.setLayout(new FlowLayout(FlowLayout.LEFT));

		painelAssistido.add(new MeuLabel("Assistido:"));
		MeuCheckBox checkAssistido = new MeuCheckBox(null);
		painelAssistido.add(checkAssistido);

		painelClassificacao.add(painelAssistido);

		JPanel painelAvaliacao = new JPanel();
		painelAvaliacao.setLayout(new FlowLayout(FlowLayout.LEFT));
		painelAvaliacao.add(new MeuLabel("Avaliação:"));
		StarRater avaliacao = new StarRater();
		painelAvaliacao.add(avaliacao);

		painelClassificacao.add(painelAvaliacao);

		JPanel painelBotao = new JPanel(new GridLayout(1, 2));

		JButton botaoSalvar = new JButton("Salvar");
		botaoSalvar.addActionListener(new BotaoListener(fieldTitulo, fieldSinopse, comboGeneros, radioOndeAssistir,
				checkAssistido, avaliacao));
		painelBotao.add(botaoSalvar);

		JButton botaoCancelar = new JButton("Cancelar");
		painelBotao.add(botaoCancelar);

		JPanel painelLista = new JPanel();
		painelLista.setLayout(new FlowLayout());

		painelDados.add(painelBotao);
		painelCadastro.add(painelDados);
		painelCadastro.add(painelClassificacao);

		abas.add("Cadastro", painelCadastro);
		abas.add("Lista", painelLista);

		framePrincipal.add(abas);

		configurarFrame(framePrincipal);
	}

	private static void configurarFrame(JFrame framePrincipal) {
		framePrincipal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		framePrincipal.setResizable(false);
		framePrincipal.setSize(520, 300);
		framePrincipal.getContentPane().setBackground(Paleta.AZUL_ESCURO);
		framePrincipal.setVisible(true);
	}

	private static void configurarAparencia() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) {
			System.err.println("Erro ao configurar a aparência da aplicação: " + e);
		}
	}

}
