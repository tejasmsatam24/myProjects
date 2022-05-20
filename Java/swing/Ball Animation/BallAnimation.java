import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

public class BallAnimation extends JPanel implements ActionListener{
	

	JButton btnStart = new JButton("Start");
	JButton btnStop = new JButton("Stop");
	AnimationPanel panel_1 = new AnimationPanel();
	
	//Construction - initialize panel and button action listeners
	public BallAnimation() {
		panel_1.setPreferredSize(new Dimension(500, 500));
		panel_1.setBackground(Color.WHITE);
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setVgap(110);
		flowLayout.setHgap(110);
		add(panel_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.LIGHT_GRAY);
		FlowLayout flowLayout_1 = (FlowLayout) panel_2.getLayout();
		flowLayout_1.setVgap(1);
		flowLayout_1.setHgap(110);
		add(panel_2);
		btnStart.setHorizontalAlignment(SwingConstants.RIGHT);

		panel_2.add(btnStart);
		btnStart.setPreferredSize(new Dimension(70, 25));
		btnStart.setVerticalAlignment(SwingConstants.BOTTOM);
		btnStop.setVerticalAlignment(SwingConstants.BOTTOM);

		panel_2.add(btnStop);
		btnStop.setEnabled(false);
		btnStart.addActionListener(this);
		btnStop.addActionListener(this);
		
	}
	
	//perform action on click of start/stop buttons
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnStart) {
			btnStop.setEnabled(true);
			panel_1.start();
			btnStart.setEnabled(false);
		}
		else if(e.getSource() == btnStop) {
			btnStart.setEnabled(true);
			panel_1.stop();
			btnStop.setEnabled(false);
		}
	}

}
