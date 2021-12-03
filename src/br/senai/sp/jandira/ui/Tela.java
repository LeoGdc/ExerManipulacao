package br.senai.sp.jandira.ui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.tools.SimpleJavaFileObject;

import br.senai.sp.jandira.Arquivo;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Tela extends JFrame {

	private JPanel contentPane;
	public Arquivo arquivo = null;
	public String caminho = "";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Tela frame = new Tela();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Tela() {

		this.arquivo = new Arquivo();
		this.caminho = "C:\\Users\\21276367\\Desktop\\teste\\arquivo.txt";

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 346, 362);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("MANIPULA\u00C7\u00C3O DE ARQUIVO");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblNewLabel.setBounds(22, 11, 256, 42);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("TEXTO");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(22, 53, 63, 14);
		contentPane.add(lblNewLabel_1);

		JTextPane txtConteudo = new JTextPane();
		txtConteudo.setBounds(22, 78, 290, 152);
		contentPane.add(txtConteudo);

		/* AÇÃO DO BOTÃO GRAVAR */
		JButton btnGravar = new JButton("GRAVAR");
		btnGravar.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				String texto = txtConteudo.getText();
				boolean teste = arquivo.escrever("C:\\Users\\21276367\\Desktop\\teste\\arquivo.txt", texto);

				if (arquivo.escrever(caminho, texto)) {
					// mensagem de sucesso
					JOptionPane.showMessageDialog(null, "GRAVAÇÃO", "DADO Gravado com Sucesso",
							JOptionPane.INFORMATION_MESSAGE);
				} else {
					// mensagem de erro
					JOptionPane.showMessageDialog(null, "ERROR", "Erro ao Gravar Dados",
							JOptionPane.INFORMATION_MESSAGE);
					txtConteudo.setText("");
				}
			}
		});

		btnGravar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnGravar.setBounds(25, 254, 89, 23);
		contentPane.add(btnGravar);

		JButton btnLimpar = new JButton("LIMPAR");
		btnLimpar.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnLimpar.setBounds(124, 254, 89, 23);
		contentPane.add(btnLimpar);

		JButton btnSair = new JButton("SAIR");
		btnSair.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnSair.setBounds(223, 254, 89, 23);
		contentPane.add(btnSair);
	}
}
