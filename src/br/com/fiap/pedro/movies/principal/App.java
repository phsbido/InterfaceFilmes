package br.com.fiap.pedro.movies.principal;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import br.com.fiap.pedro.movies.componentes.BotaoListener;
import br.com.fiap.pedro.movies.componentes.MeuCheckBox;
import br.com.fiap.pedro.movies.componentes.MeuComboBox;
import br.com.fiap.pedro.movies.componentes.MeuLabel;
import br.com.fiap.pedro.movies.componentes.MeuRadioGroup;
import br.com.fiap.pedro.movies.componentes.MeuTextArea;
import br.com.fiap.pedro.movies.componentes.MeuTextField;
import br.com.fiap.pedro.movies.dao.FilmeDAO;
import br.com.fiap.pedro.movies.model.Filme;
import br.com.fiap.pedro.movies.util.Paleta;
import br.com.fiap.pedro.movies.util.StarRater;

public class App {

	private static final String PATH_POSTER_ILHA_DO_MEDO = "src/br/com/fiap/pedro/movies/img/posterIlhaDoMedo.jpg";
	private DefaultTableModel modelo = new DefaultTableModel();
	private JButton carregar = new JButton("carregar");
	private JButton apagar = new JButton("apagar");
	private JTable tabela = new JTable(modelo);

	public static void main(String[] args) {
		App app = new App();
		app.init();
	}

	private void init() {
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

		modelo.addColumn("Id");
		modelo.addColumn("Título");
		modelo.addColumn("Sinopse");
		modelo.addColumn("Gênero");
		modelo.addColumn("Onde Assisir");
		modelo.addColumn("Assistido");
		modelo.addColumn("Avaliação");

		carregarDados();

		painelLista.add(new JScrollPane(tabela));

		JPanel botoes = new JPanel();
		botoes.add(apagar);
		botoes.add(carregar);

		painelLista.add(botoes, BorderLayout.SOUTH);

		carregar.addActionListener((ActionListener) this);
		apagar.addActionListener((ActionListener) this);

		painelDados.add(painelBotao);
		painelCadastro.add(painelDados);
		painelCadastro.add(painelClassificacao);

		abas.add("Cadastro", painelCadastro);
		abas.add("Lista", painelLista);

		framePrincipal.add(abas);

		configurarFrame(framePrincipal);
	}

	private void carregarDados() {
		modelo.setNumRows(0);

		FilmeDAO dao = new FilmeDAO();
		List<Filme> lista = dao.buscarTodos();

		for (Filme filme : lista) {
			String[] linha = { filme.getId().toString(), };
			modelo.addRow(linha);
		}
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
	
	
	private void apagar() {
		FilmeDAO dao = new FilmeDAO();
		int linha = tabela.getSelectedRow();
		String id = tabela.getValueAt(linha, 0).toString();
		Filme Filme = dao.buscarPorId(Long.valueOf(id));
		int resposta = JOptionPane.showConfirmDialog(null, "Tem certeza que quer apagar o Filme selecionado?");
		//dao.apagarPeloId(Long.valueOf(id));
		if (resposta == JOptionPane.YES_OPTION) {
			dao.apagar(Filme);
			carregarDados();
		}
	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == carregar) carregarDados();		
		if (e.getSource() == apagar) apagar();
	}

}
