package br.com.fiap.pedro.componentes;
import java.util.Enumeration;
import java.util.List;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class MeuRadioGroup extends JPanel{
	
	private static final long serialVersionUID = 5563165159504088796L;
	
	private ButtonGroup grupo = new ButtonGroup();
	private List<String> opcoes;

	public MeuRadioGroup(List<String> opcoes) {
		this.opcoes = opcoes;
		init();
	}

	private void init() {
		// Arrow function
		opcoes.forEach(opcao -> {
			JRadioButton radio = new JRadioButton(opcao);
			this.grupo.add(radio);
			this.add(radio);
		});
	}
	
	public String getSelectedButtonText( ) {
        for (Enumeration<AbstractButton> buttons = this.grupo.getElements(); buttons.hasMoreElements();) {
            AbstractButton button = buttons.nextElement();

            if (button.isSelected()) {
                return button.getText();
            }
        }

        return null;
    }
	
}
