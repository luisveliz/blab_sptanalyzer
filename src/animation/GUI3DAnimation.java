package animation;


import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.GridBagConstraints;
import javax.swing.JSpinner;
import java.awt.Insets;
import javax.swing.JCheckBox;
import java.awt.Canvas;
import javax.swing.JSlider;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class GUI3DAnimation extends JFrame 
{
	private Animation animation;

	private static final long serialVersionUID = 1L;
	private JPanel jContentPane = null;
	private JPanel jPanel_Trajectory3dAnimation = null;
	private JPanel jPanel2 = null;
	private JLabel jLabel_3D_Fps = null;
	private JSpinner jSpinner_3D_Fps = null;
	private JCheckBox jCheckBox_Antialiasing = null;
	private JCheckBox jCheckBox_3d_showAll = null;
	private JCheckBox jCheckBox_showParticles = null;
	private JCheckBox jCheckBox_showTrajectories = null;
	private JCheckBox jCheckBox_Lightning = null;
	private JPanel jPanel_3D_Canvas = null;
	private Canvas canvas_3D = null;
	private JPanel jPanel_3D_TimeLine = null;
	private JSlider jSlider_3D_RadialDistance = null;
	private JLabel jLabel_3D_RadialDistance = null;
	private JButton jButton = null;
	private JPanel jPanel1 = null;
	private JLabel jLabel_VerticalAngle = null;
	private JSlider jSlider_3D_VerticalAngle = null;
	private JPanel jPanel5 = null;
	private JSlider jSlider_3D_HorizontalAngle = null;
	private JLabel jLabel_3D_HorizontalAngle = null;

	/**
	 * This is the default constructor
	 */
	public GUI3DAnimation(Animation animation) {
		super();
		setVisible(true);
		this.animation = animation;
		initialize();
	}

	/*---------------------------------------------------*/
	//3d visualization
	public Canvas get3dCanvas()
	{
		return canvas_3D;
	}
	public Params3d getParams3d()
	{
		return new Params3d(jSlider_3D_RadialDistance.getValue(),
							jSlider_3D_VerticalAngle.getValue(),
							jSlider_3D_HorizontalAngle.getValue(),
							((Integer)jSpinner_3D_Fps.getValue()).intValue(),
							jCheckBox_Antialiasing.isSelected(),
							jCheckBox_Lightning.isSelected(),
							jCheckBox_3d_showAll.isSelected(),
							jCheckBox_showParticles.isSelected(),
							jCheckBox_showTrajectories.isSelected());
	}
	/*---------------------------------------------------*/

	/**
	 * This method initializes this
	 * 
	 * @return void
	 */
	private void initialize() {
		try {
			UIManager.setLookAndFeel( "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedLookAndFeelException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setSize(678, 430);
		this.setContentPane(getJContentPane());
		this.setTitle("3D Animation");
	}

	/**
	 * This method initializes jContentPane
	 * 
	 * @return javax.swing.JPanel
	 */
	private JPanel getJContentPane() {
		if (jContentPane == null) {
			jContentPane = new JPanel();
			jContentPane.setLayout(new BorderLayout());
			jContentPane.add(getJPanel_Trajectory3dAnimation(), BorderLayout.CENTER);
		}
		return jContentPane;
	}

	/**
	 * This method initializes jPanel_Trajectory3dAnimation	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel_Trajectory3dAnimation() {
		if (jPanel_Trajectory3dAnimation == null) {
			GridBagConstraints gridBagConstraints98 = new GridBagConstraints();
			gridBagConstraints98.fill = GridBagConstraints.NONE;
			gridBagConstraints98.gridy = 2;
			gridBagConstraints98.weightx = 0.0D;
			gridBagConstraints98.gridx = 0;
			jLabel_3D_HorizontalAngle = new JLabel();
			jLabel_3D_HorizontalAngle.setFont(new Font("SansSerif", Font.PLAIN, 10));
			jLabel_3D_HorizontalAngle.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabel_3D_HorizontalAngle.setText("Horizontal:");
			jLabel_3D_HorizontalAngle.setPreferredSize(new Dimension(60, 30));
			GridBagConstraints gridBagConstraints180 = new GridBagConstraints();
			gridBagConstraints180.fill = GridBagConstraints.BOTH;
			gridBagConstraints180.gridy = 2;
			gridBagConstraints180.weightx = 1.0D;
			gridBagConstraints180.weighty = 0.0D;
			gridBagConstraints180.gridx = 1;
			GridBagConstraints gridBagConstraints179 = new GridBagConstraints();
			gridBagConstraints179.fill = GridBagConstraints.BOTH;
			gridBagConstraints179.gridy = 1;
			gridBagConstraints179.weightx = 0.0D;
			gridBagConstraints179.weighty = 0.0D;
			gridBagConstraints179.gridx = 0;
			GridBagConstraints gridBagConstraints178 = new GridBagConstraints();
			gridBagConstraints178.fill = GridBagConstraints.NONE;
			gridBagConstraints178.gridy = 2;
			gridBagConstraints178.weightx = 0.0D;
			gridBagConstraints178.weighty = 0.0D;
			gridBagConstraints178.gridx = 2;
			GridBagConstraints gridBagConstraints88 = new GridBagConstraints();
			gridBagConstraints88.fill = GridBagConstraints.BOTH;
			gridBagConstraints88.gridy = 1;
			gridBagConstraints88.weightx = 0.0D;
			gridBagConstraints88.weighty = 1.0D;
			gridBagConstraints88.gridx = 2;
			GridBagConstraints gridBagConstraints87 = new GridBagConstraints();
			gridBagConstraints87.fill = GridBagConstraints.BOTH;
			gridBagConstraints87.gridy = 1;
			gridBagConstraints87.weightx = 1.0D;
			gridBagConstraints87.weighty = 1.0D;
			gridBagConstraints87.gridx = 1;
			GridBagConstraints gridBagConstraints165 = new GridBagConstraints();
			gridBagConstraints165.fill = GridBagConstraints.BOTH;
			gridBagConstraints165.gridx = 0;
			gridBagConstraints165.gridy = 0;
			gridBagConstraints165.gridwidth = 3;
			jPanel_Trajectory3dAnimation = new JPanel();
			jPanel_Trajectory3dAnimation.setLayout(new GridBagLayout());
			jPanel_Trajectory3dAnimation.add(getJPanel2(), gridBagConstraints165);
			jPanel_Trajectory3dAnimation.add(getJPanel_3D_Canvas(), gridBagConstraints87);
			jPanel_Trajectory3dAnimation.add(getJPanel_3D_TimeLine(), gridBagConstraints88);
			jPanel_Trajectory3dAnimation.add(getJButton(), gridBagConstraints178);
			jPanel_Trajectory3dAnimation.add(getJPanel1(), gridBagConstraints179);
			jPanel_Trajectory3dAnimation.add(getJPanel5(), gridBagConstraints180);
			jPanel_Trajectory3dAnimation.add(jLabel_3D_HorizontalAngle, gridBagConstraints98);
		}
		return jPanel_Trajectory3dAnimation;
	}

	/**
	 * This method initializes jPanel2	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel2() {
		if (jPanel2 == null) {
			GridBagConstraints gridBagConstraints85 = new GridBagConstraints();
			gridBagConstraints85.fill = GridBagConstraints.NONE;
			gridBagConstraints85.gridx = 7;
			gridBagConstraints85.gridy = 0;
			gridBagConstraints85.weightx = 0.0D;
			gridBagConstraints85.insets = new Insets(0, 0, 0, 0);
			GridBagConstraints gridBagConstraints170 = new GridBagConstraints();
			gridBagConstraints170.insets = new Insets(0, 0, 0, 10);
			gridBagConstraints170.gridy = 0;
			gridBagConstraints170.gridx = 6;
			GridBagConstraints gridBagConstraints169 = new GridBagConstraints();
			gridBagConstraints169.insets = new Insets(0, 0, 0, 10);
			gridBagConstraints169.gridy = 0;
			gridBagConstraints169.gridx = 5;
			GridBagConstraints gridBagConstraints90 = new GridBagConstraints();
			gridBagConstraints90.fill = GridBagConstraints.NONE;
			gridBagConstraints90.gridx = 4;
			gridBagConstraints90.gridy = 0;
			gridBagConstraints90.weightx = 0.0D;
			gridBagConstraints90.insets = new Insets(0, 0, 0, 10);
			GridBagConstraints gridBagConstraints164 = new GridBagConstraints();
			gridBagConstraints164.fill = GridBagConstraints.NONE;
			gridBagConstraints164.gridx = 3;
			gridBagConstraints164.gridy = 0;
			gridBagConstraints164.weightx = 0.0D;
			gridBagConstraints164.insets = new Insets(0, 0, 0, 10);
			GridBagConstraints gridBagConstraints27 = new GridBagConstraints();
			gridBagConstraints27.fill = GridBagConstraints.NONE;
			gridBagConstraints27.gridx = 1;
			gridBagConstraints27.gridy = 0;
			gridBagConstraints27.weightx = 0.0D;
			gridBagConstraints27.weighty = 0.0D;
			gridBagConstraints27.insets = new Insets(0, 0, 0, 15);
			GridBagConstraints gridBagConstraints86 = new GridBagConstraints();
			gridBagConstraints86.fill = GridBagConstraints.NONE;
			gridBagConstraints86.gridy = 0;
			gridBagConstraints86.gridx = 0;
			jLabel_3D_Fps = new JLabel();
			jLabel_3D_Fps.setHorizontalAlignment(SwingConstants.RIGHT);
			jLabel_3D_Fps.setText("FPS:");
			jPanel2 = new JPanel();
			jPanel2.setLayout(new GridBagLayout());
			jPanel2.add(jLabel_3D_Fps, gridBagConstraints86);
			jPanel2.add(getJSpinner_3D_Fps(), gridBagConstraints27);
			jPanel2.add(getJCheckBox_Antialiasing(), gridBagConstraints164);
			jPanel2.add(getJCheckBox_3d_showAll(), gridBagConstraints90);
			jPanel2.add(getJCheckBox_showParticles(), gridBagConstraints169);
			jPanel2.add(getJCheckBox_showTrajectories(), gridBagConstraints170);
			jPanel2.add(getJCheckBox_Lightning(), gridBagConstraints85);
		}
		return jPanel2;
	}

	/**
	 * This method initializes jSpinner_3D_Fps	
	 * 	
	 * @return javax.swing.JSpinner	
	 */
	private JSpinner getJSpinner_3D_Fps() {
		if (jSpinner_3D_Fps == null) {
			jSpinner_3D_Fps = new JSpinner();
			jSpinner_3D_Fps.setPreferredSize(new Dimension(50, 25));
			jSpinner_3D_Fps.setValue(60);
			jSpinner_3D_Fps.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					animation.updateGL();
				}
			});
		}
		return jSpinner_3D_Fps;
	}

	/**
	 * This method initializes jCheckBox_Antialiasing	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBox_Antialiasing() {
		if (jCheckBox_Antialiasing == null) {
			jCheckBox_Antialiasing = new JCheckBox();
			jCheckBox_Antialiasing.setHorizontalAlignment(SwingConstants.LEFT);
			jCheckBox_Antialiasing.setSelected(true);
			jCheckBox_Antialiasing.setText("Antialiasing");
			jCheckBox_Antialiasing.setVisible(true);
			jCheckBox_Antialiasing.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent arg0) {
					animation.updateGL();
				}
			});
		}
		return jCheckBox_Antialiasing;
	}

	/**
	 * This method initializes jCheckBox_3d_showAll	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBox_3d_showAll() {
		if (jCheckBox_3d_showAll == null) {
			jCheckBox_3d_showAll = new JCheckBox();
			jCheckBox_3d_showAll.setSelected(true);
			jCheckBox_3d_showAll.setText("Show All");
			jCheckBox_3d_showAll.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					animation.updateGL();
				}
			});
		}
		return jCheckBox_3d_showAll;
	}

	/**
	 * This method initializes jCheckBox_showParticles	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBox_showParticles() {
		if (jCheckBox_showParticles == null) {
			jCheckBox_showParticles = new JCheckBox();
			jCheckBox_showParticles.setSelected(true);
			jCheckBox_showParticles.setText("Show Particles");
			jCheckBox_showParticles.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					animation.updateGL();
				}
			});
		}
		return jCheckBox_showParticles;
	}

	/**
	 * This method initializes jCheckBox_showTrajectories	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBox_showTrajectories() {
		if (jCheckBox_showTrajectories == null) {
			jCheckBox_showTrajectories = new JCheckBox();
			jCheckBox_showTrajectories.setSelected(true);
			jCheckBox_showTrajectories.setText("Show Trajectories");
			jCheckBox_showTrajectories.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					animation.updateGL();
				}
			});
		}
		return jCheckBox_showTrajectories;
	}

	/**
	 * This method initializes jCheckBox_Lightning	
	 * 	
	 * @return javax.swing.JCheckBox	
	 */
	private JCheckBox getJCheckBox_Lightning() {
		if (jCheckBox_Lightning == null) {
			jCheckBox_Lightning = new JCheckBox();
			jCheckBox_Lightning.setHorizontalAlignment(SwingConstants.LEFT);
			jCheckBox_Lightning.setSelected(true);
			jCheckBox_Lightning.setText("Lightning");
			jCheckBox_Lightning.setVisible(true);
			jCheckBox_Lightning.addItemListener(new ItemListener() {
				public void itemStateChanged(ItemEvent e) {
					animation.updateGL();
				}
			});
		}
		return jCheckBox_Lightning;
	}

	/**
	 * This method initializes jPanel_3D_Canvas	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel_3D_Canvas() {
		if (jPanel_3D_Canvas == null) {
			GridBagConstraints gridBagConstraints_canvas3d = new GridBagConstraints();
			gridBagConstraints_canvas3d.fill = GridBagConstraints.BOTH;
			gridBagConstraints_canvas3d.gridy = 0;
			gridBagConstraints_canvas3d.weightx = 1.0D;
			gridBagConstraints_canvas3d.weighty = 1.0D;
			gridBagConstraints_canvas3d.gridx = 0;
			jPanel_3D_Canvas = new JPanel();
			jPanel_3D_Canvas.setLayout(new GridBagLayout());
			jPanel_3D_Canvas.setPreferredSize(new Dimension(300, 200));
			jPanel_3D_Canvas.add(getCanvas_3D(), gridBagConstraints_canvas3d);
		}
		return jPanel_3D_Canvas;
	}

	/**
	 * This method initializes canvas_3D	
	 * 	
	 * @return java.awt.Canvas	
	 */
	private Canvas getCanvas_3D() {
		if (canvas_3D == null) {
			canvas_3D = new Canvas();
		}
		return canvas_3D;
	}

	/**
	 * This method initializes jPanel_3D_TimeLine	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel_3D_TimeLine() {
		if (jPanel_3D_TimeLine == null) {
			GridBagConstraints gridBagConstraints99 = new GridBagConstraints();
			gridBagConstraints99.insets = new Insets(0, 0, 5, 0);
			gridBagConstraints99.fill = GridBagConstraints.BOTH;
			gridBagConstraints99.gridy = 0;
			gridBagConstraints99.weighty = 0.0D;
			gridBagConstraints99.gridx = 0;
			jLabel_3D_RadialDistance = new JLabel();
			jLabel_3D_RadialDistance.setFont(new Font("SansSerif", Font.PLAIN, 10));
			jLabel_3D_RadialDistance.setText("Distance:");
			jLabel_3D_RadialDistance.setHorizontalAlignment(SwingConstants.CENTER);
			GridBagConstraints gridBagConstraints94 = new GridBagConstraints();
			gridBagConstraints94.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints94.gridx = 0;
			gridBagConstraints94.gridy = 1;
			gridBagConstraints94.weightx = 0.0D;
			gridBagConstraints94.weighty = 1.0D;
			gridBagConstraints94.gridwidth = 1;
			jPanel_3D_TimeLine = new JPanel();
			jPanel_3D_TimeLine.setLayout(new GridBagLayout());
			jPanel_3D_TimeLine.setPreferredSize(new Dimension(50, 50));
			jPanel_3D_TimeLine.add(getJSlider_3D_RadialDistance(), gridBagConstraints94);
			jPanel_3D_TimeLine.add(jLabel_3D_RadialDistance, gridBagConstraints99);
		}
		return jPanel_3D_TimeLine;
	}

	/**
	 * This method initializes jSlider_3D_RadialDistance	
	 * 	
	 * @return javax.swing.JSlider	
	 */
	private JSlider getJSlider_3D_RadialDistance() {
		if (jSlider_3D_RadialDistance == null) {
			jSlider_3D_RadialDistance = new JSlider();
			jSlider_3D_RadialDistance.setPreferredSize(new Dimension(40, 200));
			jSlider_3D_RadialDistance.setMinimum(1);
			jSlider_3D_RadialDistance.setOrientation(JSlider.VERTICAL);
			jSlider_3D_RadialDistance.setPaintLabels(true);
			jSlider_3D_RadialDistance.setPaintTicks(true);
			jSlider_3D_RadialDistance.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent arg0) {
					animation.updateGL();
				}
			});
		}
		return jSlider_3D_RadialDistance;
	}

	/**
	 * This method initializes jButton	
	 * 	
	 * @return javax.swing.JButton	
	 */
	private JButton getJButton() {
		if (jButton == null) {
			jButton = new JButton();
			jButton.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) 
				{
					animation.jButton_Show_clicked();
				}
			});
			jButton.setFont(new Font("SansSerif", Font.PLAIN, 10));
			jButton.setText("Show!");
			jButton.setPreferredSize(new Dimension(60, 30));
		}
		return jButton;
	}

	/**
	 * This method initializes jPanel1	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel1() {
		if (jPanel1 == null) {
			GridBagConstraints gridBagConstraints96 = new GridBagConstraints();
			gridBagConstraints96.fill = GridBagConstraints.VERTICAL;
			gridBagConstraints96.gridx = 0;
			gridBagConstraints96.gridy = 1;
			gridBagConstraints96.weightx = 1.0;
			gridBagConstraints96.weighty = 1.0D;
			gridBagConstraints96.gridwidth = 1;
			GridBagConstraints gridBagConstraints97 = new GridBagConstraints();
			gridBagConstraints97.fill = GridBagConstraints.NONE;
			gridBagConstraints97.gridy = 0;
			gridBagConstraints97.gridx = 0;
			jLabel_VerticalAngle = new JLabel();
			jLabel_VerticalAngle.setFont(new Font("SansSerif", Font.PLAIN, 10));
			jLabel_VerticalAngle.setHorizontalAlignment(SwingConstants.LEFT);
			jLabel_VerticalAngle.setText("Vertical:");
			jLabel_VerticalAngle.setPreferredSize(new Dimension(40, 16));
			jPanel1 = new JPanel();
			jPanel1.setLayout(new GridBagLayout());
			jPanel1.setPreferredSize(new Dimension(30, 50));
			jPanel1.add(jLabel_VerticalAngle, gridBagConstraints97);
			jPanel1.add(getJSlider_3D_VerticalAngle(), gridBagConstraints96);
		}
		return jPanel1;
	}

	/**
	 * This method initializes jSlider_3D_VerticalAngle	
	 * 	
	 * @return javax.swing.JSlider	
	 */
	private JSlider getJSlider_3D_VerticalAngle() {
		if (jSlider_3D_VerticalAngle == null) {
			jSlider_3D_VerticalAngle = new JSlider();
			jSlider_3D_VerticalAngle.setFont(new Font("SansSerif", Font.PLAIN, 10));
			jSlider_3D_VerticalAngle.setInverted(true);
			jSlider_3D_VerticalAngle.setMaximum(90);
			jSlider_3D_VerticalAngle.setOrientation(JSlider.VERTICAL);
			jSlider_3D_VerticalAngle.setPaintLabels(true);
			jSlider_3D_VerticalAngle.setPaintTicks(true);
			jSlider_3D_VerticalAngle.setPreferredSize(new Dimension(40, 200));
			jSlider_3D_VerticalAngle.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					animation.updateGL();
				}
			});
		}
		return jSlider_3D_VerticalAngle;
	}

	/**
	 * This method initializes jPanel5	
	 * 	
	 * @return javax.swing.JPanel	
	 */
	private JPanel getJPanel5() {
		if (jPanel5 == null) {
			GridBagConstraints gridBagConstraints95 = new GridBagConstraints();
			gridBagConstraints95.fill = GridBagConstraints.HORIZONTAL;
			gridBagConstraints95.gridx = -1;
			gridBagConstraints95.gridy = -1;
			gridBagConstraints95.weightx = 1.0;
			gridBagConstraints95.weighty = 0.0D;
			gridBagConstraints95.gridwidth = 1;
			jPanel5 = new JPanel();
			jPanel5.setLayout(new GridBagLayout());
			jPanel5.setPreferredSize(new Dimension(100, 30));
			jPanel5.add(getJSlider_3D_HorizontalAngle(), gridBagConstraints95);
		}
		return jPanel5;
	}

	/**
	 * This method initializes jSlider_3D_HorizontalAngle	
	 * 	
	 * @return javax.swing.JSlider	
	 */
	private JSlider getJSlider_3D_HorizontalAngle() {
		if (jSlider_3D_HorizontalAngle == null) {
			jSlider_3D_HorizontalAngle = new JSlider();
			jSlider_3D_HorizontalAngle.setPreferredSize(new Dimension(200, 30));
			jSlider_3D_HorizontalAngle.setMinimum(-90);
			jSlider_3D_HorizontalAngle.setValue(0);
			jSlider_3D_HorizontalAngle.setMaximum(90);
			jSlider_3D_HorizontalAngle.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent e) {
					animation.updateGL();
				}
			});
		}
		return jSlider_3D_HorizontalAngle;
	}

}  //  @jve:decl-index=0:visual-constraint="10,10"
