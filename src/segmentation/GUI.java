package segmentation;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JSpinner;
import javax.swing.JProgressBar;
import javax.swing.JButton;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;

public class GUI extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JPanel panel_1;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	private JSpinner spinner;
	private JSpinner spinner_1;
	private JSpinner spinner_2;
	private JProgressBar progressBar;
	private JButton button;
	private JPanel panel_2;
	private ChartPanel chartPanel;
	private JPanel panel_3;
	private JLabel label_3;
	private JSpinner spinner_3;
	private JLabel label_4;
	private JSpinner spinner_4;
	private JLabel label_5;
	private JLabel label_6;
	private JSpinner spinner_5;
	private JSpinner spinner_6;
	private JProgressBar progressBar_1;
	private JButton button_1;
	private JPanel panel_4;
	private JSpinner spinner_7;
	private JLabel label_7;
	private JSpinner spinner_8;
	private JLabel label_8;
	private JProgressBar progressBar_2;
	private JButton button_2;
	private JPanel panel_5;
	private JLabel label_9;
	private JSpinner spinner_9;
	private JSpinner spinner_10;
	private JLabel label_10;
	private JLabel label_11;
	private JLabel label_12;
	private JSpinner spinner_11;
	private JSpinner spinner_12;
	private JSpinner spinner_13;
	private JSpinner spinner_14;
	private JButton button_3;

	
	
	
	
	
	
	
	
	public int jSpinner_NF_getValue()
	{
		return ((Integer)jSpinner_NFpoints.getValue()).intValue();
	}
	public int jSpinner_wMin_getValue()
	{
		return ((Integer)jSpinner_wMin.getValue()).intValue();
	}
	public int jSpinner_wMax_getValue()
	{
		return ((Integer)jSpinner_wMax.getValue()).intValue();
	}
	public int jSpinner_Dmin_getValue()
	{
		return ((Integer)jSpinner_Dmin.getValue()).intValue();
	}
	public int jSpinner_Ndiff_getValue()
	{
		return ((Integer)jSpinner_NDiff.getValue()).intValue();
	}
	public int jSpinner_NDev_getValue()
	{
		return ((Integer)jSpinner_Ndev.getValue()).intValue();
	}
	public int jSpinner_DevWMax_getValue()
	{
		return ((Integer)jSpinner_DevWmax.getValue()).intValue();
	}
	public int jSpinner_DevWMin_getValue()
	{
		return ((Integer)jSpinner_DevWmin.getValue()).intValue();
	}
	public int jSpinner_DevMin_getValue()
	{
		return ((Integer)jSpinner_DevMin.getValue()).intValue();
	}
	public int jSpinner_AsymWMax_getValue()
	{
		return ((Integer)jSpinner_AsymWmax.getValue()).intValue();
	}
	public int jSpinner_AsymWMin_getValue()
	{
		return ((Integer)jSpinner_AsymWmin.getValue()).intValue();
	}
	public int jSpinner_AsymMin_getValue()
	{
		return ((Integer)jSpinner_AsymMark.getValue()).intValue();
	}
	public jFreeChartSegmentationParams getJFreeChart_SegmentationParams()
	{
		return (jFreeChartSegmentationParams)this.cp_D.getChart();
	}
	
	public void jProgressBar_Dif_setValue(int value)
	{
		progressBar_Dif.setValue(value);
	}
	public void jProgressBar_Dev_setValue(int value)
	{
		progressBar_Dev.setValue(value);
	}
	public void jProgressBar_Asym_setValue(int value)
	{
		progressBar_Asym.setValue(value);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	/**
	 * Create the frame.
	 */
	public GUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 801, 659);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		contentPane.add(getPanel(), gbc_panel);
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			GridBagLayout gbl_panel = new GridBagLayout();
			gbl_panel.columnWidths = new int[]{0, 0, 0};
			gbl_panel.rowHeights = new int[]{0, 0, 0, 0, 0};
			gbl_panel.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
			gbl_panel.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			panel.setLayout(gbl_panel);
			GridBagConstraints gbc_panel_1 = new GridBagConstraints();
			gbc_panel_1.weighty = 1.0;
			gbc_panel_1.weightx = 0.0;
			gbc_panel_1.fill = GridBagConstraints.BOTH;
			gbc_panel_1.insets = new Insets(0, 0, 5, 5);
			gbc_panel_1.gridx = 0;
			gbc_panel_1.gridy = 0;
			panel.add(getPanel_1(), gbc_panel_1);
			GridBagConstraints gbc_panel_2 = new GridBagConstraints();
			gbc_panel_2.weightx = 1.0;
			gbc_panel_2.fill = GridBagConstraints.BOTH;
			gbc_panel_2.gridheight = 4;
			gbc_panel_2.gridx = 1;
			gbc_panel_2.gridy = 0;
			panel.add(getPanel_2(), gbc_panel_2);
			GridBagConstraints gbc_panel_3 = new GridBagConstraints();
			gbc_panel_3.weighty = 1.0;
			gbc_panel_3.weightx = 0.0;
			gbc_panel_3.fill = GridBagConstraints.BOTH;
			gbc_panel_3.insets = new Insets(0, 0, 5, 5);
			gbc_panel_3.gridx = 0;
			gbc_panel_3.gridy = 1;
			panel.add(getPanel_3(), gbc_panel_3);
			GridBagConstraints gbc_panel_4 = new GridBagConstraints();
			gbc_panel_4.weighty = 1.0;
			gbc_panel_4.weightx = 0.0;
			gbc_panel_4.gridwidth = 1;
			gbc_panel_4.fill = GridBagConstraints.BOTH;
			gbc_panel_4.insets = new Insets(0, 0, 5, 5);
			gbc_panel_4.gridx = 0;
			gbc_panel_4.gridy = 2;
			panel.add(getPanel_4(), gbc_panel_4);
			GridBagConstraints gbc_panel_5 = new GridBagConstraints();
			gbc_panel_5.weighty = 1.0;
			gbc_panel_5.weightx = 0.0;
			gbc_panel_5.fill = GridBagConstraints.BOTH;
			gbc_panel_5.insets = new Insets(0, 0, 0, 5);
			gbc_panel_5.gridx = 0;
			gbc_panel_5.gridy = 3;
			panel.add(getPanel_5(), gbc_panel_5);
		}
		return panel;
	}
	private JPanel getPanel_1() {
		if (panel_1 == null) {
			panel_1 = new JPanel();
			panel_1.setPreferredSize(new Dimension(25, 25));
			GridBagLayout gbl_panel_1 = new GridBagLayout();
			gbl_panel_1.columnWidths = new int[]{0, 0, 0, 0, 0};
			gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0};
			gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
			panel_1.setLayout(gbl_panel_1);
			GridBagConstraints gbc_label = new GridBagConstraints();
			gbc_label.insets = new Insets(0, 0, 5, 5);
			gbc_label.gridx = 0;
			gbc_label.gridy = 0;
			panel_1.add(getLabel(), gbc_label);
			GridBagConstraints gbc_spinner_2 = new GridBagConstraints();
			gbc_spinner_2.insets = new Insets(0, 0, 5, 5);
			gbc_spinner_2.gridx = 1;
			gbc_spinner_2.gridy = 0;
			panel_1.add(getSpinner_2(), gbc_spinner_2);
			GridBagConstraints gbc_label_1 = new GridBagConstraints();
			gbc_label_1.insets = new Insets(0, 0, 5, 5);
			gbc_label_1.gridx = 0;
			gbc_label_1.gridy = 1;
			panel_1.add(getLabel_1(), gbc_label_1);
			GridBagConstraints gbc_spinner = new GridBagConstraints();
			gbc_spinner.insets = new Insets(0, 0, 5, 5);
			gbc_spinner.gridx = 1;
			gbc_spinner.gridy = 1;
			panel_1.add(getSpinner(), gbc_spinner);
			GridBagConstraints gbc_label_2 = new GridBagConstraints();
			gbc_label_2.insets = new Insets(0, 0, 5, 5);
			gbc_label_2.gridx = 2;
			gbc_label_2.gridy = 1;
			panel_1.add(getLabel_2(), gbc_label_2);
			GridBagConstraints gbc_spinner_1 = new GridBagConstraints();
			gbc_spinner_1.insets = new Insets(0, 0, 5, 0);
			gbc_spinner_1.gridx = 3;
			gbc_spinner_1.gridy = 1;
			panel_1.add(getSpinner_1(), gbc_spinner_1);
			GridBagConstraints gbc_progressBar = new GridBagConstraints();
			gbc_progressBar.gridwidth = 3;
			gbc_progressBar.insets = new Insets(0, 0, 0, 5);
			gbc_progressBar.gridx = 0;
			gbc_progressBar.gridy = 2;
			panel_1.add(getProgressBar(), gbc_progressBar);
			GridBagConstraints gbc_button = new GridBagConstraints();
			gbc_button.gridx = 3;
			gbc_button.gridy = 2;
			panel_1.add(getButton(), gbc_button);
		}
		return panel_1;
	}
	private JLabel getLabel() {
		if (label == null) {
			label = new JLabel();
			label.setText("Nf points:");
		}
		return label;
	}
	private JLabel getLabel_1() {
		if (label_1 == null) {
			label_1 = new JLabel();
			label_1.setText("Wmin:");
		}
		return label_1;
	}
	private JLabel getLabel_2() {
		if (label_2 == null) {
			label_2 = new JLabel();
			label_2.setText("Wmax:");
		}
		return label_2;
	}
	private JSpinner getSpinner() {
		if (spinner == null) {
			spinner = new JSpinner();
		}
		return spinner;
	}
	private JSpinner getSpinner_1() {
		if (spinner_1 == null) {
			spinner_1 = new JSpinner();
		}
		return spinner_1;
	}
	private JSpinner getSpinner_2() {
		if (spinner_2 == null) {
			spinner_2 = new JSpinner();
		}
		return spinner_2;
	}
	private JProgressBar getProgressBar() {
		if (progressBar == null) {
			progressBar = new JProgressBar();
			progressBar.setStringPainted(true);
		}
		return progressBar;
	}
	private JButton getButton() {
		if (button == null) {
			button = new JButton();
			button.setText("Calculate D");
		}
		return button;
	}
	private JPanel getPanel_2() {
		if (panel_2 == null) {
			panel_2 = new JPanel();
			panel_2.setPreferredSize(new Dimension(25, 25));
			GridBagLayout gbl_panel_2 = new GridBagLayout();
			gbl_panel_2.columnWidths = new int[]{0, 0};
			gbl_panel_2.rowHeights = new int[]{0, 0};
			gbl_panel_2.columnWeights = new double[]{0.0, Double.MIN_VALUE};
			gbl_panel_2.rowWeights = new double[]{0.0, Double.MIN_VALUE};
			panel_2.setLayout(gbl_panel_2);
			GridBagConstraints gbc_chartPanel = new GridBagConstraints();
			gbc_chartPanel.weighty = 1.0;
			gbc_chartPanel.weightx = 1.0;
			gbc_chartPanel.fill = GridBagConstraints.BOTH;
			gbc_chartPanel.gridx = 0;
			gbc_chartPanel.gridy = 0;
			panel_2.add(getChartPanel(), gbc_chartPanel);
		}
		return panel_2;
	}
	private ChartPanel getChartPanel() {
		if (chartPanel == null) {
			chartPanel = new ChartPanel((JFreeChart) null);
		}
		return chartPanel;
	}
	private JPanel getPanel_3() {
		if (panel_3 == null) {
			panel_3 = new JPanel();
			panel_3.setPreferredSize(new Dimension(25, 25));
			GridBagLayout gbl_panel_3 = new GridBagLayout();
			gbl_panel_3.columnWidths = new int[]{0, 0, 0, 0, 0};
			gbl_panel_3.rowHeights = new int[]{0, 0, 0, 0};
			gbl_panel_3.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			gbl_panel_3.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
			panel_3.setLayout(gbl_panel_3);
			GridBagConstraints gbc_label_3 = new GridBagConstraints();
			gbc_label_3.insets = new Insets(0, 0, 5, 5);
			gbc_label_3.gridx = 0;
			gbc_label_3.gridy = 0;
			panel_3.add(getLabel_3(), gbc_label_3);
			GridBagConstraints gbc_spinner_3 = new GridBagConstraints();
			gbc_spinner_3.insets = new Insets(0, 0, 5, 5);
			gbc_spinner_3.gridx = 1;
			gbc_spinner_3.gridy = 0;
			panel_3.add(getSpinner_3(), gbc_spinner_3);
			GridBagConstraints gbc_label_4 = new GridBagConstraints();
			gbc_label_4.insets = new Insets(0, 0, 5, 5);
			gbc_label_4.gridx = 2;
			gbc_label_4.gridy = 0;
			panel_3.add(getLabel_4(), gbc_label_4);
			GridBagConstraints gbc_spinner_4 = new GridBagConstraints();
			gbc_spinner_4.insets = new Insets(0, 0, 5, 0);
			gbc_spinner_4.gridx = 3;
			gbc_spinner_4.gridy = 0;
			panel_3.add(getSpinner_4(), gbc_spinner_4);
			GridBagConstraints gbc_label_5 = new GridBagConstraints();
			gbc_label_5.insets = new Insets(0, 0, 5, 5);
			gbc_label_5.gridx = 0;
			gbc_label_5.gridy = 1;
			panel_3.add(getLabel_5(), gbc_label_5);
			GridBagConstraints gbc_spinner_5 = new GridBagConstraints();
			gbc_spinner_5.insets = new Insets(0, 0, 5, 5);
			gbc_spinner_5.gridx = 1;
			gbc_spinner_5.gridy = 1;
			panel_3.add(getSpinner_5(), gbc_spinner_5);
			GridBagConstraints gbc_label_6 = new GridBagConstraints();
			gbc_label_6.insets = new Insets(0, 0, 5, 5);
			gbc_label_6.gridx = 2;
			gbc_label_6.gridy = 1;
			panel_3.add(getLabel_6(), gbc_label_6);
			GridBagConstraints gbc_spinner_6 = new GridBagConstraints();
			gbc_spinner_6.insets = new Insets(0, 0, 5, 0);
			gbc_spinner_6.gridx = 3;
			gbc_spinner_6.gridy = 1;
			panel_3.add(getSpinner_6(), gbc_spinner_6);
			GridBagConstraints gbc_progressBar_1 = new GridBagConstraints();
			gbc_progressBar_1.gridwidth = 3;
			gbc_progressBar_1.insets = new Insets(0, 0, 0, 5);
			gbc_progressBar_1.gridx = 0;
			gbc_progressBar_1.gridy = 2;
			panel_3.add(getProgressBar_1(), gbc_progressBar_1);
			GridBagConstraints gbc_button_1 = new GridBagConstraints();
			gbc_button_1.insets = new Insets(0, 0, 0, 5);
			gbc_button_1.gridx = 3;
			gbc_button_1.gridy = 2;
			panel_3.add(getButton_1(), gbc_button_1);
		}
		return panel_3;
	}
	private JLabel getLabel_3() {
		if (label_3 == null) {
			label_3 = new JLabel();
			label_3.setText("Ndiff:");
		}
		return label_3;
	}
	private JSpinner getSpinner_3() {
		if (spinner_3 == null) {
			spinner_3 = new JSpinner();
		}
		return spinner_3;
	}
	private JLabel getLabel_4() {
		if (label_4 == null) {
			label_4 = new JLabel();
			label_4.setText("Ndev:");
		}
		return label_4;
	}
	private JSpinner getSpinner_4() {
		if (spinner_4 == null) {
			spinner_4 = new JSpinner();
		}
		return spinner_4;
	}
	private JLabel getLabel_5() {
		if (label_5 == null) {
			label_5 = new JLabel();
			label_5.setText("Wmin:");
		}
		return label_5;
	}
	private JLabel getLabel_6() {
		if (label_6 == null) {
			label_6 = new JLabel();
			label_6.setText("Wmax:");
		}
		return label_6;
	}
	private JSpinner getSpinner_5() {
		if (spinner_5 == null) {
			spinner_5 = new JSpinner();
		}
		return spinner_5;
	}
	private JSpinner getSpinner_6() {
		if (spinner_6 == null) {
			spinner_6 = new JSpinner();
		}
		return spinner_6;
	}
	private JProgressBar getProgressBar_1() {
		if (progressBar_1 == null) {
			progressBar_1 = new JProgressBar();
			progressBar_1.setStringPainted(true);
		}
		return progressBar_1;
	}
	private JButton getButton_1() {
		if (button_1 == null) {
			button_1 = new JButton();
			button_1.setText("Calculate Dev");
		}
		return button_1;
	}
	private JPanel getPanel_4() {
		if (panel_4 == null) {
			panel_4 = new JPanel();
			panel_4.setPreferredSize(new Dimension(25, 25));
			GridBagLayout gbl_panel_4 = new GridBagLayout();
			gbl_panel_4.columnWidths = new int[]{0, 0, 0, 0, 0};
			gbl_panel_4.rowHeights = new int[]{0, 0, 0};
			gbl_panel_4.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			gbl_panel_4.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
			panel_4.setLayout(gbl_panel_4);
			GridBagConstraints gbc_label_7 = new GridBagConstraints();
			gbc_label_7.insets = new Insets(0, 0, 5, 5);
			gbc_label_7.gridx = 0;
			gbc_label_7.gridy = 0;
			panel_4.add(getLabel_7(), gbc_label_7);
			GridBagConstraints gbc_spinner_7 = new GridBagConstraints();
			gbc_spinner_7.insets = new Insets(0, 0, 5, 5);
			gbc_spinner_7.gridx = 1;
			gbc_spinner_7.gridy = 0;
			panel_4.add(getSpinner_7(), gbc_spinner_7);
			GridBagConstraints gbc_label_8 = new GridBagConstraints();
			gbc_label_8.insets = new Insets(0, 0, 5, 5);
			gbc_label_8.gridx = 2;
			gbc_label_8.gridy = 0;
			panel_4.add(getLabel_8(), gbc_label_8);
			GridBagConstraints gbc_spinner_8 = new GridBagConstraints();
			gbc_spinner_8.insets = new Insets(0, 0, 5, 0);
			gbc_spinner_8.gridx = 3;
			gbc_spinner_8.gridy = 0;
			panel_4.add(getSpinner_8(), gbc_spinner_8);
			GridBagConstraints gbc_progressBar_2 = new GridBagConstraints();
			gbc_progressBar_2.gridwidth = 3;
			gbc_progressBar_2.insets = new Insets(0, 0, 0, 5);
			gbc_progressBar_2.gridx = 0;
			gbc_progressBar_2.gridy = 1;
			panel_4.add(getProgressBar_2(), gbc_progressBar_2);
			GridBagConstraints gbc_button_2 = new GridBagConstraints();
			gbc_button_2.gridx = 3;
			gbc_button_2.gridy = 1;
			panel_4.add(getButton_2(), gbc_button_2);
		}
		return panel_4;
	}
	private JSpinner getSpinner_7() {
		if (spinner_7 == null) {
			spinner_7 = new JSpinner();
		}
		return spinner_7;
	}
	private JLabel getLabel_7() {
		if (label_7 == null) {
			label_7 = new JLabel();
			label_7.setText("Wmin:");
		}
		return label_7;
	}
	private JSpinner getSpinner_8() {
		if (spinner_8 == null) {
			spinner_8 = new JSpinner();
		}
		return spinner_8;
	}
	private JLabel getLabel_8() {
		if (label_8 == null) {
			label_8 = new JLabel();
			label_8.setText("Wmax:");
		}
		return label_8;
	}
	private JProgressBar getProgressBar_2() {
		if (progressBar_2 == null) {
			progressBar_2 = new JProgressBar();
			progressBar_2.setStringPainted(true);
		}
		return progressBar_2;
	}
	private JButton getButton_2() {
		if (button_2 == null) {
			button_2 = new JButton();
			button_2.setText("CalculateAsym");
		}
		return button_2;
	}
	private JPanel getPanel_5() {
		if (panel_5 == null) {
			panel_5 = new JPanel();
			panel_5.setPreferredSize(new Dimension(350, 25));
			GridBagLayout gbl_panel_5 = new GridBagLayout();
			gbl_panel_5.columnWidths = new int[]{89, 0, 0, 0};
			gbl_panel_5.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
			gbl_panel_5.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
			gbl_panel_5.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
			panel_5.setLayout(gbl_panel_5);
			GridBagConstraints gbc_label_9 = new GridBagConstraints();
			gbc_label_9.insets = new Insets(0, 0, 5, 0);
			gbc_label_9.gridx = 2;
			gbc_label_9.gridy = 0;
			panel_5.add(getLabel_9(), gbc_label_9);
			GridBagConstraints gbc_label_10 = new GridBagConstraints();
			gbc_label_10.insets = new Insets(0, 0, 5, 5);
			gbc_label_10.gridx = 0;
			gbc_label_10.gridy = 1;
			panel_5.add(getLabel_10(), gbc_label_10);
			GridBagConstraints gbc_spinner_9 = new GridBagConstraints();
			gbc_spinner_9.insets = new Insets(0, 0, 5, 5);
			gbc_spinner_9.gridx = 1;
			gbc_spinner_9.gridy = 1;
			panel_5.add(getSpinner_9(), gbc_spinner_9);
			GridBagConstraints gbc_spinner_12 = new GridBagConstraints();
			gbc_spinner_12.insets = new Insets(0, 0, 5, 0);
			gbc_spinner_12.gridx = 2;
			gbc_spinner_12.gridy = 1;
			panel_5.add(getSpinner_12(), gbc_spinner_12);
			GridBagConstraints gbc_label_11 = new GridBagConstraints();
			gbc_label_11.insets = new Insets(0, 0, 5, 5);
			gbc_label_11.gridx = 0;
			gbc_label_11.gridy = 2;
			panel_5.add(getLabel_11(), gbc_label_11);
			GridBagConstraints gbc_spinner_10 = new GridBagConstraints();
			gbc_spinner_10.insets = new Insets(0, 0, 5, 5);
			gbc_spinner_10.gridx = 1;
			gbc_spinner_10.gridy = 2;
			panel_5.add(getSpinner_10(), gbc_spinner_10);
			GridBagConstraints gbc_spinner_13 = new GridBagConstraints();
			gbc_spinner_13.insets = new Insets(0, 0, 5, 0);
			gbc_spinner_13.gridx = 2;
			gbc_spinner_13.gridy = 2;
			panel_5.add(getSpinner_13(), gbc_spinner_13);
			GridBagConstraints gbc_label_12 = new GridBagConstraints();
			gbc_label_12.insets = new Insets(0, 0, 5, 5);
			gbc_label_12.gridx = 0;
			gbc_label_12.gridy = 3;
			panel_5.add(getLabel_12(), gbc_label_12);
			GridBagConstraints gbc_spinner_11 = new GridBagConstraints();
			gbc_spinner_11.insets = new Insets(0, 0, 5, 5);
			gbc_spinner_11.gridx = 1;
			gbc_spinner_11.gridy = 3;
			panel_5.add(getSpinner_11(), gbc_spinner_11);
			GridBagConstraints gbc_spinner_14 = new GridBagConstraints();
			gbc_spinner_14.insets = new Insets(0, 0, 5, 0);
			gbc_spinner_14.gridx = 2;
			gbc_spinner_14.gridy = 3;
			panel_5.add(getSpinner_14(), gbc_spinner_14);
			GridBagConstraints gbc_button_3 = new GridBagConstraints();
			gbc_button_3.gridx = 2;
			gbc_button_3.gridy = 4;
			panel_5.add(getButton_3(), gbc_button_3);
		}
		return panel_5;
	}
	private JLabel getLabel_9() {
		if (label_9 == null) {
			label_9 = new JLabel();
			label_9.setText("Min Duration");
		}
		return label_9;
	}
	private JSpinner getSpinner_9() {
		if (spinner_9 == null) {
			spinner_9 = new JSpinner();
			spinner_9.setPreferredSize(new Dimension(65, 28));
		}
		return spinner_9;
	}
	private JSpinner getSpinner_10() {
		if (spinner_10 == null) {
			spinner_10 = new JSpinner();
		}
		return spinner_10;
	}
	private JLabel getLabel_10() {
		if (label_10 == null) {
			label_10 = new JLabel();
			label_10.setText("D Min:");
		}
		return label_10;
	}
	private JLabel getLabel_11() {
		if (label_11 == null) {
			label_11 = new JLabel();
			label_11.setText("Dev Min:");
		}
		return label_11;
	}
	private JLabel getLabel_12() {
		if (label_12 == null) {
			label_12 = new JLabel();
			label_12.setText("Asym Min");
		}
		return label_12;
	}
	private JSpinner getSpinner_11() {
		if (spinner_11 == null) {
			spinner_11 = new JSpinner();
		}
		return spinner_11;
	}
	private JSpinner getSpinner_12() {
		if (spinner_12 == null) {
			spinner_12 = new JSpinner();
		}
		return spinner_12;
	}
	private JSpinner getSpinner_13() {
		if (spinner_13 == null) {
			spinner_13 = new JSpinner();
		}
		return spinner_13;
	}
	private JSpinner getSpinner_14() {
		if (spinner_14 == null) {
			spinner_14 = new JSpinner();
		}
		return spinner_14;
	}
	private JButton getButton_3() {
		if (button_3 == null) {
			button_3 = new JButton();
			button_3.setText("Segmentation");
		}
		return button_3;
	}
}
