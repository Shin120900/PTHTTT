package GUI;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import BLL.QLSachBLL;
import DTO.SachDTO;
import com.toedter.calendar.JDateChooser;

public class QLSachGUI {
	private JTable tbQLSach;
	private JTextField tfMaSach;
	private JTextField tfTenSach;
	private JTextField tfTacGia;
	private JTextField tfTheLoai;
	private JTextField tfNhaXuatBan;
	private JTextField tfTriGia;
	private JPanel pnTongQuanQLSach;
	private JLabel lblMessage;
	private JRadioButton rdbtnTrong;
	private JDateChooser dcNgayNhap;
	private JDateChooser dcNamXuatBan;
	private boolean isChanging = false;
	
	static QLSachGUI instance=null;
	private JTextField tfTimKiem;
	
	private QLSachGUI(){
		initialize();
		loadResources();
	}
	
	private void loadResources() {
		tbQLSach.setModel(QLSachBLL.getInstance().getResources());
	}
	
	public static QLSachGUI getInstance() {
		if(instance == null)
			instance = new QLSachGUI();
		return instance;
	}
	
	public JPanel getPnTongQuanQLSach() {
		return pnTongQuanQLSach;
	}
	
	public void reloadResources() {
		tbQLSach.setModel(QLSachBLL.getInstance().getResources());
	}
	
	private void clearField() {
		tfMaSach.setText("");
		tfNhaXuatBan.setText("");
		dcNamXuatBan.setDate(null);
		dcNgayNhap.setDate(null);
		tfTacGia.setText("");
		tfTenSach.setText("");
		tfTheLoai.setText("");
		tfTriGia.setText("");
		rdbtnTrong.setSelected(true);
	}
	
	private void setStateForTextfield() {
			tfMaSach.setEditable(isChanging);
	}
	
	private void initialize() {
		
		pnTongQuanQLSach = new JPanel();
		pnTongQuanQLSach.setBackground(SystemColor.activeCaption);
		pnTongQuanQLSach.setBounds(0, 0, 1065, 560);
		pnTongQuanQLSach.setLayout(null);
		
		JPanel pnTieuDeQLSach = new JPanel();
		pnTieuDeQLSach.setBackground(SystemColor.activeCaption);
		pnTieuDeQLSach.setBounds(0, 0, 1065, 48);
		pnTongQuanQLSach.add(pnTieuDeQLSach);
		pnTieuDeQLSach.setLayout(null);
		
		JLabel lblQLSach = new JLabel("QU???N L?? S??CH");
		lblQLSach.setForeground(Color.RED);
		lblQLSach.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblQLSach.setBounds(448, 11, 219, 35);
		pnTieuDeQLSach.add(lblQLSach);
		
		JPanel pnQLSach = new JPanel();
		pnQLSach.setBackground(SystemColor.activeCaption);
		pnQLSach.setBounds(0, 52, 1065, 230);
		pnTongQuanQLSach.add(pnQLSach);
		pnQLSach.setLayout(null);
		
		
		JPanel pnThongTinSach = new JPanel();
		pnThongTinSach.setBackground(SystemColor.activeCaption);
		pnThongTinSach.setBounds(0, 281, 1065, 279);
		pnTongQuanQLSach.add(pnThongTinSach);
		pnThongTinSach.setLayout(null);
		
		JLabel lblThongTinSach = new JLabel("TH??NG TIN S??CH");
		lblThongTinSach.setBounds(10, 5, 178, 28);
		pnThongTinSach.add(lblThongTinSach);
		lblThongTinSach.setFont(new Font("Times New Roman", Font.BOLD, 17));
		
		JPanel pnThongTinNhap = new JPanel();
		pnThongTinNhap.setBackground(SystemColor.inactiveCaptionBorder);
		pnThongTinNhap.setBounds(10, 34, 855, 234);
		pnThongTinSach.add(pnThongTinNhap);
		pnThongTinNhap.setLayout(null);
		
		JLabel lblMaSach = new JLabel("M?? s??ch:*");
		lblMaSach.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblMaSach.setBounds(24, 31, 66, 14);
		pnThongTinNhap.add(lblMaSach);
		
		tfMaSach = new JTextField();
		tfMaSach.setBounds(115, 26, 258, 32);
		tfMaSach.setFont(new Font("Times New Roman", Font.BOLD, 13));
		pnThongTinNhap.add(tfMaSach);
		tfMaSach.setColumns(10);
		
		JLabel lblTenSach = new JLabel("T??n s??ch:*");
		lblTenSach.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblTenSach.setBounds(24, 73, 66, 14);
		pnThongTinNhap.add(lblTenSach);
		
		tfTenSach = new JTextField();
		tfTenSach.setBounds(115, 69, 258, 31);
		tfTenSach.setFont(new Font("Times New Roman", Font.BOLD, 13));
		pnThongTinNhap.add(tfTenSach);
		tfTenSach.setColumns(10);
		
		JLabel lblTacGia = new JLabel("T??c gi???:");
		lblTacGia.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblTacGia.setBounds(24, 115, 66, 14);
		pnThongTinNhap.add(lblTacGia);
		
		tfTacGia = new JTextField();
		tfTacGia.setBounds(115, 111, 258, 31);
		tfTacGia.setFont(new Font("Times New Roman", Font.BOLD, 13));
		pnThongTinNhap.add(tfTacGia);
		tfTacGia.setColumns(10);
		
		JLabel lblTheLoai = new JLabel("Th??? lo???i:");
		lblTheLoai.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblTheLoai.setBounds(24, 155, 66, 23);
		pnThongTinNhap.add(lblTheLoai);
		
		JLabel lblTinhTrang = new JLabel("T??nh tr???ng:");
		lblTinhTrang.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblTinhTrang.setBounds(24, 200, 74, 14);
		pnThongTinNhap.add(lblTinhTrang);
		
		tfTheLoai = new JTextField();
		tfTheLoai.setBounds(115, 153, 258, 31);
		tfTheLoai.setFont(new Font("Times New Roman", Font.BOLD, 13));
		pnThongTinNhap.add(tfTheLoai);
		tfTheLoai.setColumns(10);
		
		rdbtnTrong = new JRadioButton("Tr???ng");
		rdbtnTrong.setFont(new Font("Times New Roman", Font.BOLD, 13));
		rdbtnTrong.setBounds(115, 196, 92, 23);
		pnThongTinNhap.add(rdbtnTrong);
		
		JLabel lblNhaXuatBan = new JLabel("Nh?? xu???t b???n:");
		lblNhaXuatBan.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNhaXuatBan.setBounds(455, 31, 74, 14);
		pnThongTinNhap.add(lblNhaXuatBan);
		
		tfNhaXuatBan = new JTextField();
		tfNhaXuatBan.setBounds(551, 26, 258, 31);
		pnThongTinNhap.add(tfNhaXuatBan);
		tfNhaXuatBan.setFont(new Font("Times New Roman", Font.BOLD, 13));
		tfNhaXuatBan.setColumns(10);
		
		JLabel lblNamXuatBan = new JLabel("N??m xu???t b???n:*");
		lblNamXuatBan.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNamXuatBan.setBounds(455, 73, 86, 14);
		pnThongTinNhap.add(lblNamXuatBan);
		
		JLabel lblNgayNhap = new JLabel("Ng??y nh???p:*");
		lblNgayNhap.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblNgayNhap.setBounds(455, 115, 74, 14);
		pnThongTinNhap.add(lblNgayNhap);
		
		JLabel lblTriGia = new JLabel("Gi?? s??ch:*");
		lblTriGia.setFont(new Font("Times New Roman", Font.BOLD, 13));
		lblTriGia.setBounds(455, 158, 73, 14);
		pnThongTinNhap.add(lblTriGia);
		
		tfTriGia = new JTextField();
		tfTriGia.setBounds(551, 153, 258, 31);
		pnThongTinNhap.add(tfTriGia);
		tfTriGia.setFont(new Font("Times New Roman", Font.BOLD, 13));
		tfTriGia.setColumns(10);
		
		lblMessage = new JLabel("");
		lblMessage.setForeground(Color.RED);
		lblMessage.setFont(new Font("Times New Roman", Font.ITALIC, 13));
		lblMessage.setBounds(115, 4, 694, 23);
		pnThongTinNhap.add(lblMessage);
		
		JLabel lblKhongBoTrong = new JLabel("(*) Kh??ng ???????c b??? tr???ng");
		lblKhongBoTrong.setForeground(Color.RED);
		lblKhongBoTrong.setFont(new Font("Times New Roman", Font.ITALIC, 13));
		lblKhongBoTrong.setBounds(455, 196, 222, 23);
		pnThongTinNhap.add(lblKhongBoTrong);
		
		dcNamXuatBan = new JDateChooser();
		dcNamXuatBan.getCalendarButton().addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		dcNamXuatBan.setBounds(551, 69, 258, 31);
		dcNamXuatBan.setDateFormatString("yyyy-MM-dd");
		pnThongTinNhap.add(dcNamXuatBan);
		
		dcNgayNhap = new JDateChooser();
		dcNgayNhap.setBounds(551, 111, 258, 31);
		dcNgayNhap.setDateFormatString("yyyy-MM-dd");
		pnThongTinNhap.add(dcNgayNhap);
		
		tbQLSach = new JTable();
		tbQLSach.setBounds(0, 0, 1050, 167);
		JScrollPane sc = new JScrollPane(tbQLSach, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		tbQLSach.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (tbQLSach.getSelectedRow()< 0)
					return;
				isChanging = false;
				setStateForTextfield();
				tfMaSach.setText(tbQLSach.getValueAt(tbQLSach.getSelectedRow(), 1).toString());
				tfTenSach.setText(tbQLSach.getValueAt(tbQLSach.getSelectedRow(), 2).toString());
				tfTheLoai.setText(tbQLSach.getValueAt(tbQLSach.getSelectedRow(), 3).toString());
				tfTacGia.setText(tbQLSach.getValueAt(tbQLSach.getSelectedRow(), 4).toString());
				tfNhaXuatBan.setText(tbQLSach.getValueAt(tbQLSach.getSelectedRow(), 5).toString());
				dcNgayNhap.setDate(Date.valueOf(tbQLSach.getValueAt(tbQLSach.getSelectedRow(), 6).toString()));
				tfTriGia.setText(tbQLSach.getValueAt(tbQLSach.getSelectedRow(), 7).toString());
				if (tbQLSach.getValueAt(tbQLSach.getSelectedRow(), 8).toString().equals("Tr???ng"))
					rdbtnTrong.setSelected(true);
				else 
					rdbtnTrong.setSelected(false);
				dcNamXuatBan.setDate(Date.valueOf(tbQLSach.getValueAt(tbQLSach.getSelectedRow(), 9).toString()));
			}
		});
		
		JButton btnThem = new JButton("Th??m");
		btnThem.setIcon(new ImageIcon("icon\\new.png"));
		btnThem.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnThem.setBounds(900, 34, 138, 41);
		btnThem.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String tinhTrang;
				if (rdbtnTrong.isSelected())
					tinhTrang = "Tr???ng";
				else
					tinhTrang = "??ang ???????c m?????n";
				try {
					Calendar cal = dcNamXuatBan.getCalendar();
					java.util.Date date = cal.getTime();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					String nxb = sdf.format(date);
					cal = dcNgayNhap.getCalendar();
					date = cal.getTime();
					String nn = sdf.format(date);
					SachDTO s = new SachDTO(tfMaSach.getText(), tfTacGia.getText(), tfTenSach.getText(), tfTheLoai.getText(), tfNhaXuatBan.getText(), 
						Date.valueOf(nn), tfTriGia.getText(), tinhTrang, Date.valueOf(nxb));
					String result = QLSachBLL.getInstance().addProcessing(s);
					lblMessage.setText(result);
					reloadResources();
				}
				catch(Exception ex) {
					lblMessage.setText("Ki???m tra l???i ng??y th??ng");
				}
			}
		});
		pnThongTinSach.add(btnThem);
		
		JButton btnSua = new JButton("S???a\r\n");
		btnSua.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String tinhTrang;
					if (rdbtnTrong.isSelected())
						tinhTrang = "Tr???ng";
					else
						tinhTrang = "??ang ???????c m?????n";
					Calendar cal = dcNamXuatBan.getCalendar();
					java.util.Date date = cal.getTime();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					String nxb = sdf.format(date);
					cal = dcNgayNhap.getCalendar();
					date = cal.getTime();
					String nn = sdf.format(date);
					SachDTO s = new SachDTO(tfMaSach.getText(), tfTacGia.getText(), tfTenSach.getText(), tfTheLoai.getText(), tfNhaXuatBan.getText(), 
							Date.valueOf(nn), tfTriGia.getText(), tinhTrang, Date.valueOf(nxb));
					String result = QLSachBLL.getInstance().changeProcessing(s);
					lblMessage.setText(result);
					reloadResources();
				}
				catch(Exception ex) {
					lblMessage.setText("Ki???m tra l???i ng??y th??ng");
				}
			}
		});
		btnSua.setIcon(new ImageIcon("icon\\setting.png"));
		btnSua.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnSua.setBounds(900, 98, 138, 41);
		pnThongTinSach.add(btnSua);
		
		JButton btnHuy = new JButton("H???y");
		btnHuy.setIcon(new ImageIcon("icon\\del.png"));
		btnHuy.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnHuy.setBounds(900, 161, 138, 41);
		pnThongTinSach.add(btnHuy);
		btnHuy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				clearField();
				isChanging = true;
				setStateForTextfield();
			}
		});
		
		JButton btnXoa = new JButton("X??a");
		btnXoa.setIcon(new ImageIcon("icon\\delete.png"));
		btnXoa.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnXoa.setBounds(900, 226, 138, 41);
		pnThongTinSach.add(btnXoa);
		btnXoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String msg = QLSachBLL.getInstance().deleteProcessing(tfMaSach.getText());
				lblMessage.setText(msg);
				reloadResources();
				clearField();
			}
		});
		
		
	
		pnQLSach.add(sc);
		sc.setBounds(0, 44, 1055, 186);
		
		tfTimKiem = new JTextField();
		tfTimKiem.setToolTipText("Nh???p m?? s??ch ho???c t??n s??ch,...");
		tfTimKiem.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		tfTimKiem.setBounds(559, 5, 337, 30);
		pnQLSach.add(tfTimKiem);
		tfTimKiem.setColumns(10);
		
		JButton btnTimKiem = new JButton("T??m ki???m");
		btnTimKiem.setIcon(new ImageIcon("icon\\find.png"));
		btnTimKiem.setFont(new Font("Times New Roman", Font.BOLD, 14));
		btnTimKiem.setBounds(919, 4, 134, 35);
		btnTimKiem.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(tfTimKiem.getText().length()==0)
					JOptionPane.showMessageDialog(null, "B???n ch??a nh???p t??? kh??a c???n t??m!","Th??ng b??o",1);
				else {
					tbQLSach.setModel(QLSachBLL.getInstance().timKiem(tfTimKiem.getText()));
				}
				
			}
		});
		pnQLSach.add(btnTimKiem);
	}	
}
