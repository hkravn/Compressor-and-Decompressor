package user_interface;

import main.compressor;
import main.decompressor;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class mainFrame extends JFrame implements ActionListener {
    JButton compress;
    JButton decompress;
    JPanel panel;
    File file;

    public mainFrame() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(400,400);
        //this.getContentPane().setBackground(new Color(125,125,125));
        this.setTitle("Compression & Decompression App");

        panel = new JPanel();

        compress = new JButton("Select file to compress");
        compress.setBounds(20,200,150,50);
        compress.addActionListener(this);
        panel.add(compress);

        decompress = new JButton("Select file to decompress");
        decompress.setBounds(200,200,150,50);
        decompress.addActionListener(this);
        panel.add(decompress);

        this.getContentPane().add(panel);
        this.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        int res = fileChooser.showSaveDialog(null);

        if (res==JFileChooser.APPROVE_OPTION) {
            file = new File(fileChooser.getSelectedFile().getAbsolutePath());
        }

        if (e.getSource()==compress) {
            try {
                compressor.compressFile(file);
                JOptionPane.showMessageDialog(null,"Compressed Successfully!!!");
            } catch (Exception err) {
                JOptionPane.showMessageDialog(null,err.toString());
            }
        } else {
            try {
                decompressor.decompressFile(file);
                JOptionPane.showMessageDialog(null,"Decompressed Successfully!!!");
            } catch (Exception err) {
                JOptionPane.showMessageDialog(null,err.toString());
            }
        }
    }
}
