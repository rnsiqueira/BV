package br.com.rnsiqueira.interfaces;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import br.com.rnsiqueira.calculos.RegraCorrecao;
import br.com.rnsiqueira.calculos.RegraCorrecaoDescida;
import br.com.rnsiqueira.calculos.RegraCorrecaoSubida;
import br.com.rnsiqueira.modelo.Papel;
import javax.swing.JButton;

public class Trade {

	private JFrame frame;

	private Papel papel = new Papel();
	private RegraCorrecao gap;
	private JTextField inputA;
	private JTextField inputB;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Trade window = new Trade();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Trade() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 720, 451);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setTitle("PullBack Of Gap with Fibonacci");

		JLabel lblDeveloper = new JLabel("2019 - Developer: Rafael N. Siqueira");
		lblDeveloper.setBounds(363, 387, 311, 14);
		frame.getContentPane().add(lblDeveloper);

		JLabel lblValorA = new JLabel("Valor A:");
		lblValorA.setBounds(10, 22, 88, 14);
		frame.getContentPane().add(lblValorA);

		JLabel lblValorB = new JLabel("Valor B:");
		lblValorB.setBounds(10, 78, 46, 14);
		frame.getContentPane().add(lblValorB);

		inputA = new JTextField();
		inputA.setBounds(10, 47, 181, 20);
		frame.getContentPane().add(inputA);
		inputA.setColumns(10);

		inputB = new JTextField();
		inputB.setBounds(10, 103, 181, 20);
		frame.getContentPane().add(inputB);
		inputB.setColumns(10);

		JRadioButton rdbtnTedenciaSubida = new JRadioButton("Tendência Subida");
		rdbtnTedenciaSubida.setBounds(47, 156, 244, 23);
		frame.getContentPane().add(rdbtnTedenciaSubida);
		
		rdbtnTedenciaSubida.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				gap = new RegraCorrecaoSubida();
				
			}
		});

		JRadioButton rdbtnTendnciaDescida = new JRadioButton("Tend\u00EAncia Descida");
		rdbtnTendnciaDescida.setBounds(47, 193, 244, 23);
		frame.getContentPane().add(rdbtnTendnciaDescida);
		
		
		rdbtnTendnciaDescida.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				gap = new RegraCorrecaoDescida();
				
			}
		});

		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnTedenciaSubida);
		bg.add(rdbtnTendnciaDescida);

		JLabel lblPrecisoBaixa = new JLabel("Precis\u00E3o Baixa:");
		lblPrecisoBaixa.setBounds(356, 53, 116, 14);
		frame.getContentPane().add(lblPrecisoBaixa);

		JLabel lblPrecisoMdio = new JLabel("Precis\u00E3o M\u00E9dia:");
		lblPrecisoMdio.setBounds(356, 78, 116, 14);
		frame.getContentPane().add(lblPrecisoMdio);

		JLabel lblPrecisoAlta = new JLabel("Precis\u00E3o Alta:");
		lblPrecisoAlta.setBounds(356, 106, 116, 14);
		frame.getContentPane().add(lblPrecisoAlta);

		JLabel valorBaixo = new JLabel("0.00");
		valorBaixo.setBounds(513, 50, 161, 14);
		frame.getContentPane().add(valorBaixo);

		JLabel valormedio = new JLabel("0.00");
		valormedio.setBounds(513, 78, 181, 14);
		frame.getContentPane().add(valormedio);

		JLabel valorAlto = new JLabel("0.00");
		valorAlto.setBounds(513, 106, 181, 14);
		frame.getContentPane().add(valorAlto);

		JLabel lblForaCompravenda = new JLabel("For\u00E7a Compra/Venda:");
		lblForaCompravenda.setBounds(268, 230, 161, 14);
		frame.getContentPane().add(lblForaCompravenda);

		JLabel valorPullBack = new JLabel("0.00");
		valorPullBack.setBounds(450, 230, 244, 14);
		frame.getContentPane().add(valorPullBack);
		
		JButton botaoCalcular = new JButton("Calcular");
		botaoCalcular.setBounds(228, 292, 89, 23);
		frame.getContentPane().add(botaoCalcular);
		
		
		botaoCalcular.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				papel.setValorA(new Double(inputA.getText()));
				papel.setValorB(new Double(inputB.getText()));
				
				gap.diferenca(papel);
				
				valorBaixo.setText(gap.valorBaixo().toString());
				valormedio.setText(gap.valorMedio().toString());
				valorAlto.setText(gap.valorAlto().toString());
				valorPullBack.setText(gap.pullBack().toString());
				
			}
		});
	}
}
