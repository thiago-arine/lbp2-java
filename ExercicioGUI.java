import javax.swing.*;
import java.awt.*;

class window extends JFrame {
    public window(){
        setTitle("Login - LBP2");
        setSize(800,600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        JPanel forms = new JPanel(new GridLayout(2,2));

        JLabel user = new JLabel("Usuário:");
        JTextField username = new JTextField();

        JLabel password = new JLabel("Senha:");
        JPasswordField user_password = new JPasswordField();

        forms.add(user);
        forms.add(username);
        forms.add(password);
        forms.add(user_password);

        JPanel button = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JButton register_button = new JButton("Entrar");

        button.add(register_button);


        register_button.addActionListener(f -> {
            String message1 = "Login efetuado com sucesso!";
            String message2 = "Usuário ou senha inválidos!";
            String password_txt = new String(user_password.getPassword());
            String username_txt = username.getText();
            if(username_txt.equals("Teste") && password_txt.equals("1234")){
                JOptionPane.showMessageDialog(null, message1);
            } else {
                JOptionPane.showMessageDialog(null, message2);
                username.setText("");
                user_password.setText("");
            }
        });

        add(forms, BorderLayout.CENTER);
        add(button, BorderLayout.SOUTH);

    }
    public static void main(String[] args) {
        SwingUtilities.invokeLater(
                () -> {
                    new window().setVisible(true);
                }
        );
    }
}