import java.awt.FileDialog;
import java.io.File;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import org.jaudiotagger.audio.AudioFile;
import org.jaudiotagger.audio.AudioFileIO;
import org.jaudiotagger.audio.AudioHeader;
import org.jaudiotagger.tag.FieldKey;
import org.jaudiotagger.tag.Tag;

public class Reproduce extends JFrame {

	public String filename;

	/** Creates new form reproduce */
	public Reproduce() {
		this.setTitle("Prueba JLayer con MP3");
		initComponents();
	}

	/**
	 * This method is called from within the constructor to initialize the form.
	 * WARNING: Do NOT modify this code. The content of this method is always
	 * regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
	// <editor-fold defaultstate="collapsed"
	// desc="Generated Code">//GEN-BEGIN:initComponents
	private void initComponents() {

		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();
		jButton3 = new javax.swing.JButton();
		jButton4 = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jButton1.setText("Abrir");
		final Reproduce frame = this;
		jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				FileDialog fd = new FileDialog(frame, "Abrir", FileDialog.LOAD);
				fd.setVisible(true);
				File f = new File(fd.getDirectory(), fd.getFile());
				filename = fd.getDirectory() + fd.getFile();
				System.out.println(filename);
				if (pri != null) {
					pri.stop();
				}
				pri = new Principal(filename);
			}
		});

		jButton2.setText("STOP");
		jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseClicked(java.awt.event.MouseEvent evt) {
				pri.stop();
			}
		});
		jButton3.setText("Play");
		jButton3.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseReleased(java.awt.event.MouseEvent evt) {
				pri.play();
			}
		});
		
		
		
		texto = new JLabel("0:00");
		
		
		final JFrame aux = this;
		jButton4.setText("Info");
		jButton4.addMouseListener(new java.awt.event.MouseAdapter() {
			public void mouseReleased(java.awt.event.MouseEvent evt) {
				if (filename != null) {
					try {
						File f = new File(filename);

						AudioFile af = AudioFileIO.read(f);
						Tag tag = af.getTag();
						AudioHeader ah = af.getAudioHeader();

						JOptionPane.showMessageDialog(aux,
								"Artista: " + tag.getFirst(FieldKey.ARTIST));
						JOptionPane.showMessageDialog(aux,
								"Titulo: " + tag.getFirst(FieldKey.TITLE));
						JOptionPane.showMessageDialog(aux,
								"Album: " + tag.getFirst(FieldKey.ALBUM));
						JOptionPane.showMessageDialog(aux,
								"Duracion: " + (ah.getTrackLength() / 60) + ":"
										+ (ah.getTrackLength() % 60));
						JOptionPane.showMessageDialog(aux,
								"Genero: " + tag.getFirst(FieldKey.GENRE));
						JOptionPane.showMessageDialog(aux, "Posici�n actual: "
								+ pri.damePos());
						JOptionPane.showMessageDialog(aux, "N� de pista: "
								+ tag.getFirst(FieldKey.TRACK));
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
			}
		});
		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
				getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(
				javax.swing.GroupLayout.Alignment.LEADING).addGroup(
				layout.createSequentialGroup().addGap(32, 32, 32)
						.addComponent(jButton1).addGap(28, 28, 28)
						.addComponent(jButton2).addGap(36, 36, 36)
						.addComponent(jButton3).addGap(40, 40, 40)
						.addComponent(jButton4).addGap(32, 32, 32)
						.addContainerGap(65, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout
				.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(
						layout.createSequentialGroup()
								.addGap(96, 96, 96)
								.addGroup(
										layout.createParallelGroup(
												javax.swing.GroupLayout.Alignment.BASELINE)
												.addComponent(jButton1)
												.addComponent(jButton2)
												.addComponent(jButton3)
												.addComponent(jButton4))
								.addContainerGap(181, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	/**
	 * @param args
	 *            the command line arguments
	 */

	public static void main(String args[]) {

		Reproduce r = new Reproduce();
		r.setVisible(true);
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JButton jButton4;
	private javax.swing.JLabel texto;
	private Principal pri;
	// End of variables declaration//GEN-END:variables

}
