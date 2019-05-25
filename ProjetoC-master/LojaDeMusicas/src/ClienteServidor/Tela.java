package ClienteServidor;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.text.DecimalFormat;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import dbo.Musicas;
import java.awt.Font;

public class Tela {
	private Cliente cliente;
	private JFrame janela;
	private JTextField txtBusca;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the application.
	 * 
	 * @throws Exception
	 */
	public Tela(Cliente cliente) throws Exception {
		this.cliente = cliente;
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Exception
	 */
	private void initialize() throws Exception {
		janela = new JFrame();
		janela.setResizable(false);
		janela.setTitle("Music Store");
		janela.setBounds(100, 100, 710, 553);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.getContentPane().setLayout(null);

		txtBusca = new JTextField();
		txtBusca.setBounds(56, 44, 254, 20);
		janela.getContentPane().add(txtBusca);
		txtBusca.setColumns(10);

		DefaultListModel<Musicas> modelMusicas = new DefaultListModel<>();
		DefaultListModel<Musicas> modelDesejos = new DefaultListModel<>();

		JScrollPane scrMusicas = new JScrollPane();
		scrMusicas.setBounds(56, 123, 573, 128);
		janela.getContentPane().add(scrMusicas);

		JList<Musicas> listMusicas = new JList<Musicas>();
		scrMusicas.setViewportView(listMusicas);
		listMusicas.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		
		JLabel textValor = new JLabel("");
		textValor.setBounds(564, 44, 118, 20);
		janela.getContentPane().add(textValor);

		JScrollPane scrDesejos = new JScrollPane();
		scrDesejos.setBounds(56, 287, 573, 126);
		janela.getContentPane().add(scrDesejos);
		
		JButton btnNewButton_1 = new JButton("Comprar");
		btnNewButton_1.setEnabled(false);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});

		JList<Musicas> listDesejos = new JList<Musicas>();
		scrDesejos.setViewportView(listDesejos);
		listDesejos.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		JButton btnBuscar = new JButton("Buscar");
		btnBuscar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					modelMusicas.clear();
					cliente.limparMusicas();

					listMusicas.setModel(modelMusicas);
					cliente.tratarConexao("CON", txtBusca.getText());

					while (!cliente.getListMusicas().isVazia()) {
						modelMusicas.addElement(cliente.getListMusicas().getItem());
						listMusicas.getSelectedValue();
						cliente.getListMusicas().removeItem();
					}

				} catch (Exception erro) {
					erro.printStackTrace();
				}

			}
		});
		btnBuscar.setBounds(328, 44, 89, 20);
		janela.getContentPane().add(btnBuscar);

		JButton btnSalvar = new JButton("+ Lista de Desejos");
		btnSalvar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					listDesejos.setModel(modelDesejos);
					cliente.getListDesejos().insereItem(listMusicas.getSelectedValue());
					modelDesejos.addElement(listMusicas.getSelectedValue());
					listMusicas.clearSelection();
					double valorDasMusicas = 0;
					int tempoTotalMusicas = 0;
					
					if (modelDesejos.isEmpty() == false) {
						btnNewButton_1.setEnabled(true);
					}
					for(int i = 0; i < modelDesejos.getSize(); i++) {
						System.out.println(modelDesejos.elementAt(i));
						valorDasMusicas += modelDesejos.elementAt(i).getPreco();
						tempoTotalMusicas += modelDesejos.elementAt(i).getTempo();
					}
					
					if (tempoTotalMusicas > 30 && tempoTotalMusicas < 60) {
						valorDasMusicas -= valorDasMusicas * 0.1;
					}

					if (tempoTotalMusicas > 60 && tempoTotalMusicas < 90) {
						valorDasMusicas -= valorDasMusicas * 0.2;
					}

					if (tempoTotalMusicas > 90) {
						valorDasMusicas -= valorDasMusicas * 0.3;
					}
					DecimalFormat format = new DecimalFormat("###.##");
					textValor.setText("R$ " + format.format(valorDasMusicas));
				} catch (Exception erro) {
					JOptionPane.showMessageDialog(null, "Nada Selecionado!", "alert", JOptionPane.ERROR_MESSAGE);
				};
			}
		});
		btnSalvar.setBounds(56, 442, 156, 23);
		janela.getContentPane().add(btnSalvar);

		JLabel lblNewLabel_1 = new JLabel("Lista de M\u00FAsicas");
		lblNewLabel_1.setBounds(56, 100, 110, 14);
		janela.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Lista de Desejos");
		lblNewLabel_2.setBounds(56, 262, 110, 14);
		janela.getContentPane().add(lblNewLabel_2);

		btnNewButton_1.setBounds(340, 442, 89, 23);
		janela.getContentPane().add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Sair");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					cliente.tratarConexao("FIC", "");
					System.exit(0);

				} catch (Exception erro) {
					erro.printStackTrace();
				}
			}
		});
		btnNewButton_2.setBounds(540, 442, 89, 23);
		janela.getContentPane().add(btnNewButton_2);

		JButton btnLimpar = new JButton("Limpar");
		btnLimpar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					cliente.limparMusicas();
					cliente.limparMDesejos();
					txtBusca.setText("");
					textValor.setText("");
					modelMusicas.clear();
					modelDesejos.clear();
					btnNewButton_1.setEnabled(false);
				} catch (Exception erro) {
					erro.printStackTrace();
				}
			}
		});
		btnLimpar.setBounds(439, 442, 89, 23);
		janela.getContentPane().add(btnLimpar);

		JLabel lblValorDaCompra = new JLabel("VALOR TOTAL:");
		lblValorDaCompra.setBounds(454, 47, 99, 14);
		janela.getContentPane().add(lblValorDaCompra);
		

		janela.setVisible(true);
	}
}
