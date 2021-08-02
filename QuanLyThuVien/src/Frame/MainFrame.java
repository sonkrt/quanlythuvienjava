/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frame;

import Dao.DocGia_Dao;
import Dao.MuonSach_Dao;
import Dao.Sach_Dao;
import Dao.TaiKhoan_Dao;
import Dao.TheLoaiSach_Dao;
import Pojo.DocGia_Pojo;
import Pojo.MuonSach_Pojo;
import Pojo.Sach_Pojo;
import Pojo.TheLoaiSach_Pojo;
import Pojo.ThuThu_Pojo;
import java.awt.Color;
import java.awt.Font;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

/**
 *
 * @author Asus
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    DefaultTableModel mdtb,mdtbDocgia,mdtbSach,mdtbMuonSach;
    DefaultComboBoxModel mdcbbMaTheLoaiSach,mdcbbMaTheMS,mdcbbMaSachMS;
    
    private String tenDN;
    private String maThuThu;
    private int quyen;
    public MainFrame() {
        initComponents();
        setLocationRelativeTo(null);
        this.tenDN = tenDN;
        TaiKhoan_Dao tk = new TaiKhoan_Dao();
        ThuThu_Pojo tt = tk.layThongTinThuThu(tenDN);
        this.maThuThu = tt.getMaTT();
        this.quyen = tt.getQuyen();
        loadTheLoaiSach();
        loadSach();
    }
    public MainFrame(String tenDN) {
        initComponents();
        setLocationRelativeTo(null);
        this.tenDN = tenDN;
        TaiKhoan_Dao tk = new TaiKhoan_Dao();
        ThuThu_Pojo tt = tk.layThongTinThuThu(tenDN);
        this.maThuThu = tt.getMaTT();
        this.quyen = tt.getQuyen();
        loadTheLoaiSach();
        loadSach();
    }
    private static boolean checkMa(int ma,ArrayList<String> list){
        for(int i = 0 ;i<list.size();i++){
            String a = list.get(i).substring(2);
            if(ma == Integer.parseInt(a)){
                return false;
            }
        }
        return true;
    }
    public void loadTheLoaiSach(){
        mdtb = new DefaultTableModel();
        mdcbbMaTheLoaiSach = new DefaultComboBoxModel();
        mdtb.addColumn("Mã loại");
        mdtb.addColumn("Tên thể loại");
        tbTheLoaiSach.getTableHeader().setFont(new Font("Calibri", Font.PLAIN, 18));
        tbTheLoaiSach.getTableHeader().setForeground(Color.blue);
        TheLoaiSach_Dao tls = new TheLoaiSach_Dao();
        ArrayList<TheLoaiSach_Pojo> list = tls.layDsTheLoaiSach();
        mdtb.setRowCount(0);
        for(TheLoaiSach_Pojo s: list){
            Vector<Object> vec = new Vector<Object>();
            vec.add(s.getMaLoai());
            vec.add(s.getTheLoai());
            mdcbbMaTheLoaiSach.addElement(s);
            mdtb.addRow(vec);
        }
        tbTheLoaiSach.setModel(mdtb);
        cbbmaTheLoai.setModel(mdcbbMaTheLoaiSach);

        tbTheLoaiSach.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(e.getValueIsAdjusting() == false){
                    int index = tbTheLoaiSach.getSelectedRow();
                    if(index < 0 ){
                        btXoaTheLoaiSach.setEnabled(false);
                        btSuaTheLoaiSach.setEnabled(false);
                        txtMaSach.setEnabled(false);
                        return;
                    }
                    btXoaTheLoaiSach.setEnabled(true);
                    btSuaTheLoaiSach.setEnabled(true);
                    txtMaSach.setEnabled(true);
                    txtMaSach.setText((String) mdtb.getValueAt(index, 0));
                    txtTheLoaiSach.setText((String) mdtb.getValueAt(index, 1));
                }
            }
        });
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btGroupPhaiDocGia = new javax.swing.ButtonGroup();
        containerPanel = new javax.swing.JPanel();
        menuPanel = new javax.swing.JPanel();
        btSach = new javax.swing.JButton();
        btDocGia = new javax.swing.JButton();
        btMuonTra = new javax.swing.JButton();
        btThongKe = new javax.swing.JButton();
        btTaiKhoan = new javax.swing.JButton();
        lbLoGo = new javax.swing.JLabel();
        contentPanel = new javax.swing.JPanel();
        sachPanel = new javax.swing.JPanel();
        menuSachPanel = new javax.swing.JPanel();
        btTabSach = new javax.swing.JButton();
        btTabTheLoai = new javax.swing.JButton();
        containerSachTheLoai = new javax.swing.JPanel();
        theLoaiPanel = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tbTheLoaiSach = new javax.swing.JTable();
        boxTextControlTheLoaiSach = new javax.swing.JPanel();
        boxTextFieldTheLoaiSach = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        txtMaSach = new javax.swing.JTextField();
        txtTheLoaiSach = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        btThemTheLoaiSach = new javax.swing.JButton();
        btXoaTheLoaiSach = new javax.swing.JButton();
        btSuaTheLoaiSach = new javax.swing.JButton();
        btRefeshTheLoaiSach = new javax.swing.JButton();
        txtBoxSearchTheLoaiSach = new javax.swing.JTextField();
        btSearchTheLoaiSach = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        sachSachPanel = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        jPanel16 = new javax.swing.JPanel();
        bttThemSach = new javax.swing.JButton();
        bttXoaSach = new javax.swing.JButton();
        bttSuaSach = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        txtmasach = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txttensach = new javax.swing.JTextField();
        jLabel19 = new javax.swing.JLabel();
        cbbmaTheLoai = new javax.swing.JComboBox<>();
        jLabel20 = new javax.swing.JLabel();
        txtsoluong = new javax.swing.JTextField();
        jLabel21 = new javax.swing.JLabel();
        txtnxb = new javax.swing.JTextField();
        jLabel22 = new javax.swing.JLabel();
        txtnamxb = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        txttacgia = new javax.swing.JTextField();
        txtSearchSach = new javax.swing.JTextField();
        bttSearchSach = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        tbSach = new javax.swing.JTable();
        bttRefreshSach = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jLabel38 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        docGiaPanel = new javax.swing.JPanel();
        docGiaPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        tbDocGia = new javax.swing.JTable();
        boxTextControlTheLoaiSach1 = new javax.swing.JPanel();
        boxTextFieldTheLoaiSach1 = new javax.swing.JPanel();
        txtMaTheTV = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtHoTenDG = new javax.swing.JTextField();
        txtSoDTDG = new javax.swing.JTextField();
        txtDiaChiDG = new javax.swing.JTextField();
        txtNgayCap = new javax.swing.JTextField();
        txtNgayHetHan = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        btThemDocGia = new javax.swing.JButton();
        btXoaDocGia = new javax.swing.JButton();
        btSuaDocGia = new javax.swing.JButton();
        jLabel16 = new javax.swing.JLabel();
        rdbPhaiNamDG = new javax.swing.JRadioButton();
        rdbNuDG = new javax.swing.JRadioButton();
        jPanel1 = new javax.swing.JPanel();
        btgiaHanThe = new javax.swing.JButton();
        btDSTheHetHan = new javax.swing.JButton();
        btRefeshDocGia = new javax.swing.JButton();
        txtBoxSearchDocGia = new javax.swing.JTextField();
        btSearchDocGia = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        muonTraPanel = new javax.swing.JPanel();
        MuonTraPn = new javax.swing.JPanel();
        jPanel17 = new javax.swing.JPanel();
        jPanel18 = new javax.swing.JPanel();
        btTraSachMuonSach = new javax.swing.JButton();
        btSuaMuonSach = new javax.swing.JButton();
        btXoaMuonSach = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtGhiChuMuonSach = new javax.swing.JTextArea();
        btKiemTraMuonSach = new javax.swing.JButton();
        btThemMuonSach1 = new javax.swing.JButton();
        jPanel8 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        txtNgayMuonMuonSach = new javax.swing.JTextField();
        jLabel34 = new javax.swing.JLabel();
        txtNgayTraMuonSach = new javax.swing.JTextField();
        jLabel35 = new javax.swing.JLabel();
        txtHanTraMuonSach = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        txtTrinhTrangMuonSach = new javax.swing.JTextField();
        lbMaThuThuMuonSach = new javax.swing.JLabel();
        cbbMaSachMuonSach = new javax.swing.JComboBox<>();
        cbbMaTheMuonSach = new javax.swing.JComboBox<>();
        jLabel37 = new javax.swing.JLabel();
        txtTienPhatMuonSach = new javax.swing.JTextField();
        txtSearchMuonSach = new javax.swing.JTextField();
        btSearchMuonSach = new javax.swing.JButton();
        jScrollPane5 = new javax.swing.JScrollPane();
        tbMuonSach = new javax.swing.JTable();
        btRefreshMuonSach = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        thongKePanel = new javax.swing.JPanel();
        taiKhoanPanel = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        txtThayDoiMK = new javax.swing.JPasswordField();
        jLabel29 = new javax.swing.JLabel();
        txtNhapLaiMK = new javax.swing.JPasswordField();
        txtHoTenThuThu = new javax.swing.JTextField();
        txtEmailThuThu = new javax.swing.JTextField();
        txtSoDTThuThu = new javax.swing.JTextField();
        lbTenDN = new javax.swing.JLabel();
        btSuaTTTK = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        btDangXuat = new javax.swing.JButton();
        btTaoMoiTaiKhoan = new javax.swing.JButton();
        jPanel11 = new javax.swing.JPanel();
        jLabel41 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Quản lý thư viện");

        containerPanel.setBackground(new java.awt.Color(255, 255, 255));

        menuPanel.setBackground(new java.awt.Color(0, 204, 153));
        menuPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));

        btSach.setBackground(new java.awt.Color(255, 255, 255));
        btSach.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btSach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/sach.png"))); // NOI18N
        btSach.setText("SÁCH");
        btSach.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btSach.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btSachMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btSachMouseExited(evt);
            }
        });
        btSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSachActionPerformed(evt);
            }
        });

        btDocGia.setBackground(new java.awt.Color(255, 255, 255));
        btDocGia.setFont(new java.awt.Font("Calibri", 1, 14)); // NOI18N
        btDocGia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/docGia.png"))); // NOI18N
        btDocGia.setText("ĐỘC GIẢ");
        btDocGia.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btDocGia.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btDocGiaMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btDocGiaMouseExited(evt);
            }
        });
        btDocGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDocGiaActionPerformed(evt);
            }
        });

        btMuonTra.setBackground(new java.awt.Color(255, 255, 255));
        btMuonTra.setFont(new java.awt.Font("Calibri", 1, 13)); // NOI18N
        btMuonTra.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/muonTraSach.png"))); // NOI18N
        btMuonTra.setText("MƯỢN/TRẢ");
        btMuonTra.setIconTextGap(3);
        btMuonTra.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btMuonTra.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btMuonTraMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btMuonTraMouseExited(evt);
            }
        });
        btMuonTra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btMuonTraActionPerformed(evt);
            }
        });

        btThongKe.setBackground(new java.awt.Color(255, 255, 255));
        btThongKe.setFont(new java.awt.Font("Calibri", 1, 13)); // NOI18N
        btThongKe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/thongke.png"))); // NOI18N
        btThongKe.setText("THỐNG KÊ");
        btThongKe.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btThongKe.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btThongKeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btThongKeMouseExited(evt);
            }
        });
        btThongKe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThongKeActionPerformed(evt);
            }
        });

        btTaiKhoan.setBackground(new java.awt.Color(255, 255, 255));
        btTaiKhoan.setFont(new java.awt.Font("Calibri", 1, 13)); // NOI18N
        btTaiKhoan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/account.png"))); // NOI18N
        btTaiKhoan.setText("TÀI KHOẢN");
        btTaiKhoan.setMargin(new java.awt.Insets(2, 2, 2, 2));
        btTaiKhoan.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                btTaiKhoanMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                btTaiKhoanMouseExited(evt);
            }
        });
        btTaiKhoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTaiKhoanActionPerformed(evt);
            }
        });

        lbLoGo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/logoNew.PNG"))); // NOI18N

        javax.swing.GroupLayout menuPanelLayout = new javax.swing.GroupLayout(menuPanel);
        menuPanel.setLayout(menuPanelLayout);
        menuPanelLayout.setHorizontalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btSach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btThongKe, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btMuonTra, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btDocGia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btTaiKhoan, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuPanelLayout.createSequentialGroup()
                        .addGap(0, 9, Short.MAX_VALUE)
                        .addComponent(lbLoGo)))
                .addContainerGap())
        );
        menuPanelLayout.setVerticalGroup(
            menuPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuPanelLayout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(lbLoGo, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btSach)
                .addGap(5, 5, 5)
                .addComponent(btDocGia)
                .addGap(5, 5, 5)
                .addComponent(btMuonTra)
                .addGap(5, 5, 5)
                .addComponent(btThongKe)
                .addGap(5, 5, 5)
                .addComponent(btTaiKhoan)
                .addGap(10, 10, 10))
        );

        contentPanel.setBackground(new java.awt.Color(255, 255, 255));
        contentPanel.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0), new java.awt.Color(0, 0, 0)));
        contentPanel.setLayout(new java.awt.CardLayout());

        menuSachPanel.setBackground(new java.awt.Color(0, 204, 153));

        btTabSach.setBackground(new java.awt.Color(255, 255, 255));
        btTabSach.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        btTabSach.setText("Sách");
        btTabSach.setMaximumSize(new java.awt.Dimension(120, 35));
        btTabSach.setPreferredSize(new java.awt.Dimension(120, 35));
        btTabSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTabSachActionPerformed(evt);
            }
        });

        btTabTheLoai.setBackground(new java.awt.Color(255, 255, 255));
        btTabTheLoai.setFont(new java.awt.Font("Calibri", 1, 15)); // NOI18N
        btTabTheLoai.setText("Thể loại sách");
        btTabTheLoai.setMaximumSize(new java.awt.Dimension(120, 35));
        btTabTheLoai.setPreferredSize(new java.awt.Dimension(120, 35));
        btTabTheLoai.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTabTheLoaiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout menuSachPanelLayout = new javax.swing.GroupLayout(menuSachPanel);
        menuSachPanel.setLayout(menuSachPanelLayout);
        menuSachPanelLayout.setHorizontalGroup(
            menuSachPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuSachPanelLayout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(btTabSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btTabTheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        menuSachPanelLayout.setVerticalGroup(
            menuSachPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(menuSachPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(btTabSach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btTabTheLoai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        containerSachTheLoai.setLayout(new java.awt.CardLayout());

        theLoaiPanel.setBackground(new java.awt.Color(255, 255, 255));

        tbTheLoaiSach.setBackground(new java.awt.Color(204, 255, 255));
        tbTheLoaiSach.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        tbTheLoaiSach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbTheLoaiSach.setFocusable(false);
        tbTheLoaiSach.setRowHeight(25);
        tbTheLoaiSach.setSelectionBackground(new java.awt.Color(241, 57, 83));
        tbTheLoaiSach.getTableHeader().setReorderingAllowed(false);
        jScrollPane2.setViewportView(tbTheLoaiSach);

        boxTextControlTheLoaiSach.setBackground(new java.awt.Color(255, 255, 255));
        boxTextControlTheLoaiSach.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        boxTextFieldTheLoaiSach.setBackground(new java.awt.Color(255, 255, 255));

        jLabel6.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel6.setText("Mã sách :");

        jLabel7.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel7.setText("Tên thể loại sách :");

        txtMaSach.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        txtMaSach.setEnabled(false);

        txtTheLoaiSach.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N

        javax.swing.GroupLayout boxTextFieldTheLoaiSachLayout = new javax.swing.GroupLayout(boxTextFieldTheLoaiSach);
        boxTextFieldTheLoaiSach.setLayout(boxTextFieldTheLoaiSachLayout);
        boxTextFieldTheLoaiSachLayout.setHorizontalGroup(
            boxTextFieldTheLoaiSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, boxTextFieldTheLoaiSachLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(boxTextFieldTheLoaiSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(boxTextFieldTheLoaiSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtTheLoaiSach, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        boxTextFieldTheLoaiSachLayout.setVerticalGroup(
            boxTextFieldTheLoaiSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, boxTextFieldTheLoaiSachLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(boxTextFieldTheLoaiSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(txtMaSach, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, 18)
                .addGroup(boxTextFieldTheLoaiSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTheLoaiSach, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        btThemTheLoaiSach.setBackground(new java.awt.Color(255, 255, 255));
        btThemTheLoaiSach.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        btThemTheLoaiSach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/plus.png"))); // NOI18N
        btThemTheLoaiSach.setText("Thêm thể loại sách");
        btThemTheLoaiSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThemTheLoaiSachActionPerformed(evt);
            }
        });

        btXoaTheLoaiSach.setBackground(new java.awt.Color(255, 255, 255));
        btXoaTheLoaiSach.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        btXoaTheLoaiSach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/delete.png"))); // NOI18N
        btXoaTheLoaiSach.setText("Xóa thể loại sách");
        btXoaTheLoaiSach.setEnabled(false);
        btXoaTheLoaiSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btXoaTheLoaiSachActionPerformed(evt);
            }
        });

        btSuaTheLoaiSach.setBackground(new java.awt.Color(255, 255, 255));
        btSuaTheLoaiSach.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        btSuaTheLoaiSach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/clean.png"))); // NOI18N
        btSuaTheLoaiSach.setText("Sửa thể loại sách");
        btSuaTheLoaiSach.setEnabled(false);
        btSuaTheLoaiSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSuaTheLoaiSachActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(btSuaTheLoaiSach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btXoaTheLoaiSach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btThemTheLoaiSach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(10, 10, 10))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addComponent(btThemTheLoaiSach, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(btXoaTheLoaiSach, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(btSuaTheLoaiSach, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout boxTextControlTheLoaiSachLayout = new javax.swing.GroupLayout(boxTextControlTheLoaiSach);
        boxTextControlTheLoaiSach.setLayout(boxTextControlTheLoaiSachLayout);
        boxTextControlTheLoaiSachLayout.setHorizontalGroup(
            boxTextControlTheLoaiSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(boxTextControlTheLoaiSachLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addComponent(boxTextFieldTheLoaiSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(131, Short.MAX_VALUE))
        );
        boxTextControlTheLoaiSachLayout.setVerticalGroup(
            boxTextControlTheLoaiSachLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(boxTextControlTheLoaiSachLayout.createSequentialGroup()
                .addGap(45, 45, 45)
                .addComponent(boxTextFieldTheLoaiSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(53, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, boxTextControlTheLoaiSachLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20))
        );

        btRefeshTheLoaiSach.setBackground(new java.awt.Color(255, 255, 255));
        btRefeshTheLoaiSach.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btRefeshTheLoaiSach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/update.png"))); // NOI18N
        btRefeshTheLoaiSach.setText("Refresh");
        btRefeshTheLoaiSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRefeshTheLoaiSachActionPerformed(evt);
            }
        });

        txtBoxSearchTheLoaiSach.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N

        btSearchTheLoaiSach.setBackground(new java.awt.Color(255, 255, 255));
        btSearchTheLoaiSach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/search.png"))); // NOI18N
        btSearchTheLoaiSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSearchTheLoaiSachActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 102), 2));

        jLabel9.setBackground(new java.awt.Color(0, 204, 153));
        jLabel9.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText(" Thể loại sách ");
        jLabel9.setOpaque(true);

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/logo.gif"))); // NOI18N

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel10)
                .addGap(5, 5, 5))
            .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addComponent(jLabel10, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9))
        );

        javax.swing.GroupLayout theLoaiPanelLayout = new javax.swing.GroupLayout(theLoaiPanel);
        theLoaiPanel.setLayout(theLoaiPanelLayout);
        theLoaiPanelLayout.setHorizontalGroup(
            theLoaiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(theLoaiPanelLayout.createSequentialGroup()
                .addGroup(theLoaiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(boxTextControlTheLoaiSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(theLoaiPanelLayout.createSequentialGroup()
                        .addGroup(theLoaiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(theLoaiPanelLayout.createSequentialGroup()
                                .addGap(50, 50, 50)
                                .addComponent(btRefeshTheLoaiSach)))
                        .addGap(5, 5, 5)
                        .addGroup(theLoaiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(theLoaiPanelLayout.createSequentialGroup()
                                .addComponent(txtBoxSearchTheLoaiSach)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btSearchTheLoaiSach))
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 679, Short.MAX_VALUE))))
                .addGap(103, 103, 103))
        );
        theLoaiPanelLayout.setVerticalGroup(
            theLoaiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(theLoaiPanelLayout.createSequentialGroup()
                .addGroup(theLoaiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(theLoaiPanelLayout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(166, 166, 166)
                        .addComponent(btRefeshTheLoaiSach, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(theLoaiPanelLayout.createSequentialGroup()
                        .addGroup(theLoaiPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(theLoaiPanelLayout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(txtBoxSearchTheLoaiSach, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(6, 6, 6))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, theLoaiPanelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(btSearchTheLoaiSach, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(10, 10, 10)
                .addComponent(boxTextControlTheLoaiSach, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        containerSachTheLoai.add(theLoaiPanel, "card3");

        sachSachPanel.setBackground(new java.awt.Color(255, 255, 255));

        jPanel15.setBackground(new java.awt.Color(255, 255, 255));
        jPanel15.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel16.setBackground(new java.awt.Color(255, 255, 255));

        bttThemSach.setBackground(new java.awt.Color(255, 255, 255));
        bttThemSach.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        bttThemSach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/plus.png"))); // NOI18N
        bttThemSach.setText("Thêm sách");
        bttThemSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttThemSachActionPerformed(evt);
            }
        });

        bttXoaSach.setBackground(new java.awt.Color(255, 255, 255));
        bttXoaSach.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        bttXoaSach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/delete.png"))); // NOI18N
        bttXoaSach.setText("Xóa sách");
        bttXoaSach.setEnabled(false);
        bttXoaSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttXoaSachActionPerformed(evt);
            }
        });

        bttSuaSach.setBackground(new java.awt.Color(255, 255, 255));
        bttSuaSach.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        bttSuaSach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/clean.png"))); // NOI18N
        bttSuaSach.setText("Sửa sách");
        bttSuaSach.setEnabled(false);
        bttSuaSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttSuaSachActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel16Layout = new javax.swing.GroupLayout(jPanel16);
        jPanel16.setLayout(jPanel16Layout);
        jPanel16Layout.setHorizontalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel16Layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(bttSuaSach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bttXoaSach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(bttThemSach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(98, 98, 98))
        );
        jPanel16Layout.setVerticalGroup(
            jPanel16Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel16Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(bttThemSach)
                .addGap(20, 20, 20)
                .addComponent(bttXoaSach)
                .addGap(20, 20, 20)
                .addComponent(bttSuaSach))
        );

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));

        jLabel17.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel17.setText("Mã sách:");

        txtmasach.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        txtmasach.setEnabled(false);

        jLabel18.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel18.setText("Tên sách:");

        txttensach.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N

        jLabel19.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel19.setText("Mã loại:");

        cbbmaTheLoai.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel20.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel20.setText("Số lượng:");

        txtsoluong.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N

        jLabel21.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel21.setText("Nhà xuất bản:");

        txtnxb.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N

        jLabel22.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel22.setText("Năm xuất bản:");

        txtnamxb.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N

        jLabel23.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel23.setText("Tác giả:");

        txttacgia.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel5Layout.createSequentialGroup()
                            .addGap(8, 8, 8)
                            .addComponent(jLabel17))
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel19)
                            .addComponent(jLabel18)
                            .addComponent(jLabel20)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel22)
                            .addComponent(jLabel21)
                            .addComponent(jLabel23))
                        .addGap(5, 5, 5)))
                .addGap(31, 31, 31)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(txtmasach, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(25, Short.MAX_VALUE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txttensach, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(txtsoluong, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 220, Short.MAX_VALUE)
                                .addComponent(txtnxb)
                                .addComponent(txtnamxb, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txttacgia, javax.swing.GroupLayout.Alignment.LEADING))
                            .addComponent(cbbmaTheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtmasach, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel17)))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel18)
                            .addComponent(txttensach, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel19)
                            .addComponent(cbbmaTheLoai, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(txtsoluong, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel20))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addComponent(jLabel21))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(txtnxb, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtnamxb, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel23)
                    .addComponent(txttacgia, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(12, Short.MAX_VALUE))
        );

        txtSearchSach.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        bttSearchSach.setBackground(new java.awt.Color(255, 255, 255));
        bttSearchSach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/search.png"))); // NOI18N
        bttSearchSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttSearchSachActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel15Layout = new javax.swing.GroupLayout(jPanel15);
        jPanel15.setLayout(jPanel15Layout);
        jPanel15Layout.setHorizontalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtSearchSach, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(bttSearchSach, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel15Layout.createSequentialGroup()
                        .addGap(120, 120, 120)
                        .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, 204, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel15Layout.setVerticalGroup(
            jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel15Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel15Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(jPanel15Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(bttSearchSach, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(txtSearchSach, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                .addGap(37, 37, 37)
                .addComponent(jPanel16, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tbSach.setBackground(new java.awt.Color(204, 255, 255));
        tbSach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbSach.setFocusable(false);
        tbSach.setRowHeight(25);
        tbSach.setSelectionBackground(new java.awt.Color(241, 57, 83));
        jScrollPane4.setViewportView(tbSach);

        bttRefreshSach.setBackground(new java.awt.Color(255, 255, 255));
        bttRefreshSach.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        bttRefreshSach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/update.png"))); // NOI18N
        bttRefreshSach.setText("Refresh");
        bttRefreshSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bttRefreshSachActionPerformed(evt);
            }
        });

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 102), 2));

        jLabel38.setBackground(new java.awt.Color(0, 204, 153));
        jLabel38.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel38.setForeground(new java.awt.Color(255, 255, 255));
        jLabel38.setText("          Sách ");
        jLabel38.setOpaque(true);

        jLabel39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/logo.gif"))); // NOI18N

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel10Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jLabel39)
                .addGap(5, 5, 5))
            .addComponent(jLabel38, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel10Layout.createSequentialGroup()
                .addComponent(jLabel39, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel38))
        );

        javax.swing.GroupLayout sachSachPanelLayout = new javax.swing.GroupLayout(sachSachPanel);
        sachSachPanel.setLayout(sachSachPanelLayout);
        sachSachPanelLayout.setHorizontalGroup(
            sachSachPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sachSachPanelLayout.createSequentialGroup()
                .addGroup(sachSachPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sachSachPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jPanel15, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sachSachPanelLayout.createSequentialGroup()
                        .addGroup(sachSachPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(sachSachPanelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(bttRefreshSach))
                            .addGroup(sachSachPanelLayout.createSequentialGroup()
                                .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 776, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(33, 33, 33))
        );
        sachSachPanelLayout.setVerticalGroup(
            sachSachPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sachSachPanelLayout.createSequentialGroup()
                .addGroup(sachSachPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(sachSachPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 229, Short.MAX_VALUE))
                    .addGroup(sachSachPanelLayout.createSequentialGroup()
                        .addComponent(jPanel10, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(bttRefreshSach)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel15, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        containerSachTheLoai.add(sachSachPanel, "card2");

        javax.swing.GroupLayout sachPanelLayout = new javax.swing.GroupLayout(sachPanel);
        sachPanel.setLayout(sachPanelLayout);
        sachPanelLayout.setHorizontalGroup(
            sachPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(menuSachPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(containerSachTheLoai, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        sachPanelLayout.setVerticalGroup(
            sachPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sachPanelLayout.createSequentialGroup()
                .addComponent(menuSachPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(containerSachTheLoai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        contentPanel.add(sachPanel, "card2");

        docGiaPanel.setBackground(new java.awt.Color(255, 255, 255));

        docGiaPanel2.setBackground(new java.awt.Color(255, 255, 255));
        docGiaPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tbDocGia.setBackground(new java.awt.Color(204, 255, 255));
        tbDocGia.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        tbDocGia.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbDocGia.setFocusable(false);
        tbDocGia.setRowHeight(25);
        tbDocGia.setSelectionBackground(new java.awt.Color(241, 57, 83));
        tbDocGia.getTableHeader().setReorderingAllowed(false);
        jScrollPane3.setViewportView(tbDocGia);

        docGiaPanel2.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(119, 59, 790, 260));

        boxTextControlTheLoaiSach1.setBackground(new java.awt.Color(255, 255, 255));
        boxTextControlTheLoaiSach1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        boxTextFieldTheLoaiSach1.setBackground(new java.awt.Color(255, 255, 255));
        boxTextFieldTheLoaiSach1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        txtMaTheTV.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        txtMaTheTV.setEnabled(false);
        boxTextFieldTheLoaiSach1.add(txtMaTheTV, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 10, 180, 27));

        jLabel1.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel1.setText("Mã thẻ : ");
        boxTextFieldTheLoaiSach1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(44, 20, -1, -1));

        jLabel5.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel5.setText("Họ và Tên : ");
        boxTextFieldTheLoaiSach1.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(29, 52, -1, -1));

        jLabel8.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel8.setText("Số DT : ");
        boxTextFieldTheLoaiSach1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(53, 129, -1, -1));

        jLabel13.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel13.setText("Địa chỉ : ");
        boxTextFieldTheLoaiSach1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(47, 169, -1, -1));

        jLabel14.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel14.setText("Ngày hết hạn : ");
        boxTextFieldTheLoaiSach1.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 240, -1, -1));

        jLabel15.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel15.setText("Ngày cấp : ");
        boxTextFieldTheLoaiSach1.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(33, 204, -1, 20));

        txtHoTenDG.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        boxTextFieldTheLoaiSach1.add(txtHoTenDG, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 47, 180, 27));

        txtSoDTDG.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        boxTextFieldTheLoaiSach1.add(txtSoDTDG, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 119, 180, 27));

        txtDiaChiDG.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        boxTextFieldTheLoaiSach1.add(txtDiaChiDG, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 156, 180, 27));

        txtNgayCap.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        txtNgayCap.setEnabled(false);
        boxTextFieldTheLoaiSach1.add(txtNgayCap, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 193, 180, 27));

        txtNgayHetHan.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        txtNgayHetHan.setEnabled(false);
        boxTextFieldTheLoaiSach1.add(txtNgayHetHan, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 230, 180, 27));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        btThemDocGia.setBackground(new java.awt.Color(255, 255, 255));
        btThemDocGia.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        btThemDocGia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/plus.png"))); // NOI18N
        btThemDocGia.setText("ĐK thẻ");
        btThemDocGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThemDocGiaActionPerformed(evt);
            }
        });

        btXoaDocGia.setBackground(new java.awt.Color(255, 255, 255));
        btXoaDocGia.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        btXoaDocGia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/delete.png"))); // NOI18N
        btXoaDocGia.setText("Xóa thẻ");
        btXoaDocGia.setEnabled(false);
        btXoaDocGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btXoaDocGiaActionPerformed(evt);
            }
        });

        btSuaDocGia.setBackground(new java.awt.Color(255, 255, 255));
        btSuaDocGia.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        btSuaDocGia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/clean.png"))); // NOI18N
        btSuaDocGia.setText("Sửa thẻ");
        btSuaDocGia.setEnabled(false);
        btSuaDocGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSuaDocGiaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btSuaDocGia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btXoaDocGia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btThemDocGia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btThemDocGia, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(btXoaDocGia, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(btSuaDocGia, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        boxTextFieldTheLoaiSach1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 50, 160, 180));

        jLabel16.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jLabel16.setText("Phái : ");
        boxTextFieldTheLoaiSach1.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 90, -1, -1));

        rdbPhaiNamDG.setBackground(new java.awt.Color(255, 255, 255));
        btGroupPhaiDocGia.add(rdbPhaiNamDG);
        rdbPhaiNamDG.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        rdbPhaiNamDG.setText("Nam");
        boxTextFieldTheLoaiSach1.add(rdbPhaiNamDG, new org.netbeans.lib.awtextra.AbsoluteConstraints(105, 84, 60, -1));

        rdbNuDG.setBackground(new java.awt.Color(255, 255, 255));
        btGroupPhaiDocGia.add(rdbNuDG);
        rdbNuDG.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        rdbNuDG.setText("Nữ");
        boxTextFieldTheLoaiSach1.add(rdbNuDG, new org.netbeans.lib.awtextra.AbsoluteConstraints(181, 84, 60, -1));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        btgiaHanThe.setBackground(new java.awt.Color(255, 255, 255));
        btgiaHanThe.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        btgiaHanThe.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/plus1.png"))); // NOI18N
        btgiaHanThe.setText("Gia hạn thẻ");
        btgiaHanThe.setEnabled(false);
        btgiaHanThe.setIconTextGap(8);
        btgiaHanThe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btgiaHanTheActionPerformed(evt);
            }
        });

        btDSTheHetHan.setBackground(new java.awt.Color(255, 255, 255));
        btDSTheHetHan.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        btDSTheHetHan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/menu.png"))); // NOI18N
        btDSTheHetHan.setText("DS thẻ hết hạn");
        btDSTheHetHan.setIconTextGap(6);
        btDSTheHetHan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDSTheHetHanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btDSTheHetHan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btgiaHanThe, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(btgiaHanThe, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(btDSTheHetHan)
                .addContainerGap(52, Short.MAX_VALUE))
        );

        boxTextFieldTheLoaiSach1.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 50, 220, 180));

        javax.swing.GroupLayout boxTextControlTheLoaiSach1Layout = new javax.swing.GroupLayout(boxTextControlTheLoaiSach1);
        boxTextControlTheLoaiSach1.setLayout(boxTextControlTheLoaiSach1Layout);
        boxTextControlTheLoaiSach1Layout.setHorizontalGroup(
            boxTextControlTheLoaiSach1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, boxTextControlTheLoaiSach1Layout.createSequentialGroup()
                .addContainerGap(91, Short.MAX_VALUE)
                .addComponent(boxTextFieldTheLoaiSach1, javax.swing.GroupLayout.PREFERRED_SIZE, 769, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(38, 38, 38))
        );
        boxTextControlTheLoaiSach1Layout.setVerticalGroup(
            boxTextControlTheLoaiSach1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(boxTextControlTheLoaiSach1Layout.createSequentialGroup()
                .addComponent(boxTextFieldTheLoaiSach1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 8, Short.MAX_VALUE))
        );

        docGiaPanel2.add(boxTextControlTheLoaiSach1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 330, 900, 270));

        btRefeshDocGia.setBackground(new java.awt.Color(255, 255, 255));
        btRefeshDocGia.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btRefeshDocGia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/update.png"))); // NOI18N
        btRefeshDocGia.setText("Refresh");
        btRefeshDocGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRefeshDocGiaActionPerformed(evt);
            }
        });
        docGiaPanel2.add(btRefeshDocGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 280, -1, 35));

        txtBoxSearchDocGia.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        docGiaPanel2.add(txtBoxSearchDocGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(118, 20, 710, 30));

        btSearchDocGia.setBackground(new java.awt.Color(255, 255, 255));
        btSearchDocGia.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/search.png"))); // NOI18N
        btSearchDocGia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSearchDocGiaActionPerformed(evt);
            }
        });
        docGiaPanel2.add(btSearchDocGia, new org.netbeans.lib.awtextra.AbsoluteConstraints(830, 20, -1, 30));

        jLabel11.setBackground(new java.awt.Color(0, 204, 153));
        jLabel11.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel11.setForeground(new java.awt.Color(255, 255, 255));
        jLabel11.setText("     Độc giả");
        jLabel11.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 102, 102), 2, true));
        jLabel11.setOpaque(true);
        docGiaPanel2.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 100, -1));

        javax.swing.GroupLayout docGiaPanelLayout = new javax.swing.GroupLayout(docGiaPanel);
        docGiaPanel.setLayout(docGiaPanelLayout);
        docGiaPanelLayout.setHorizontalGroup(
            docGiaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(docGiaPanelLayout.createSequentialGroup()
                .addComponent(docGiaPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        docGiaPanelLayout.setVerticalGroup(
            docGiaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, docGiaPanelLayout.createSequentialGroup()
                .addComponent(docGiaPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        contentPanel.add(docGiaPanel, "card3");

        muonTraPanel.setBackground(new java.awt.Color(255, 255, 255));

        MuonTraPn.setBackground(new java.awt.Color(255, 255, 255));

        jPanel17.setBackground(new java.awt.Color(255, 255, 255));
        jPanel17.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        jPanel18.setBackground(new java.awt.Color(255, 255, 255));

        btTraSachMuonSach.setBackground(new java.awt.Color(255, 255, 255));
        btTraSachMuonSach.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        btTraSachMuonSach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/trasach.png"))); // NOI18N
        btTraSachMuonSach.setText("Trả sách");
        btTraSachMuonSach.setEnabled(false);
        btTraSachMuonSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTraSachMuonSachActionPerformed(evt);
            }
        });

        btSuaMuonSach.setBackground(new java.awt.Color(255, 255, 255));
        btSuaMuonSach.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        btSuaMuonSach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/clean.png"))); // NOI18N
        btSuaMuonSach.setText("Chỉnh Sửa");
        btSuaMuonSach.setEnabled(false);
        btSuaMuonSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSuaMuonSachActionPerformed(evt);
            }
        });

        btXoaMuonSach.setBackground(new java.awt.Color(255, 255, 255));
        btXoaMuonSach.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        btXoaMuonSach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/delete.png"))); // NOI18N
        btXoaMuonSach.setText("Xóa");
        btXoaMuonSach.setEnabled(false);
        btXoaMuonSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btXoaMuonSachActionPerformed(evt);
            }
        });

        txtGhiChuMuonSach.setColumns(20);
        txtGhiChuMuonSach.setRows(5);
        txtGhiChuMuonSach.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Ghi chú", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.TOP, new java.awt.Font("Tahoma", 0, 14))); // NOI18N
        jScrollPane1.setViewportView(txtGhiChuMuonSach);

        btKiemTraMuonSach.setBackground(new java.awt.Color(255, 255, 255));
        btKiemTraMuonSach.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btKiemTraMuonSach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/tick.png"))); // NOI18N
        btKiemTraMuonSach.setText("Kiểm tra");
        btKiemTraMuonSach.setEnabled(false);
        btKiemTraMuonSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btKiemTraMuonSachActionPerformed(evt);
            }
        });

        btThemMuonSach1.setBackground(new java.awt.Color(255, 255, 255));
        btThemMuonSach1.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        btThemMuonSach1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/muonsach.png"))); // NOI18N
        btThemMuonSach1.setText("Mượn sách");
        btThemMuonSach1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btThemMuonSach1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel18Layout = new javax.swing.GroupLayout(jPanel18);
        jPanel18.setLayout(jPanel18Layout);
        jPanel18Layout.setHorizontalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel18Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btSuaMuonSach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btThemMuonSach1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btXoaMuonSach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(30, 30, 30)
                        .addComponent(btKiemTraMuonSach)
                        .addGap(28, 28, 28)
                        .addComponent(btTraSachMuonSach))
                    .addComponent(jScrollPane1))
                .addContainerGap())
        );
        jPanel18Layout.setVerticalGroup(
            jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel18Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btThemMuonSach1)
                .addGap(10, 10, 10)
                .addGroup(jPanel18Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSuaMuonSach)
                    .addComponent(btKiemTraMuonSach)
                    .addComponent(btTraSachMuonSach))
                .addGap(10, 10, 10)
                .addComponent(btXoaMuonSach)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));

        jLabel30.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel30.setText("Mã thẻ :");

        jLabel31.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel31.setText("Mã sách :");

        jLabel32.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel32.setText("Mã thủ thư :");

        jLabel33.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel33.setText("Ngày mượn :");

        txtNgayMuonMuonSach.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        txtNgayMuonMuonSach.setEnabled(false);

        jLabel34.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel34.setText("Ngày trả :");

        txtNgayTraMuonSach.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        txtNgayTraMuonSach.setEnabled(false);

        jLabel35.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel35.setText("Hạn trả :");

        txtHanTraMuonSach.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        txtHanTraMuonSach.setEnabled(false);

        jLabel36.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel36.setText("Tình trạng :");

        txtTrinhTrangMuonSach.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        txtTrinhTrangMuonSach.setEnabled(false);

        cbbMaSachMuonSach.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbbMaTheMuonSach.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel37.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel37.setText("Tiền phạt :");

        txtTienPhatMuonSach.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        txtTienPhatMuonSach.setEnabled(false);

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel37)
                            .addComponent(jLabel30)
                            .addComponent(jLabel31)
                            .addComponent(jLabel34)
                            .addComponent(jLabel35)
                            .addComponent(jLabel36)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel33))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel32)))
                .addGap(31, 31, 31)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(txtNgayMuonMuonSach)
                    .addComponent(txtTrinhTrangMuonSach)
                    .addComponent(lbMaThuThuMuonSach, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cbbMaSachMuonSach, 0, 162, Short.MAX_VALUE)
                    .addComponent(cbbMaTheMuonSach, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtTienPhatMuonSach)
                    .addComponent(txtNgayTraMuonSach)
                    .addComponent(txtHanTraMuonSach, javax.swing.GroupLayout.Alignment.TRAILING))
                .addGap(0, 19, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel30)
                    .addComponent(cbbMaTheMuonSach, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbbMaSachMuonSach, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel31))
                .addGap(8, 8, 8)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbMaThuThuMuonSach, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel32))
                .addGap(8, 8, 8)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNgayMuonMuonSach, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel33))
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel34)
                        .addGap(8, 8, 8)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtHanTraMuonSach, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTrinhTrangMuonSach, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel36)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(txtNgayTraMuonSach, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(8, 8, 8)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel37)
                    .addComponent(txtTienPhatMuonSach, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(5, 5, 5))
        );

        txtSearchMuonSach.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N

        btSearchMuonSach.setBackground(new java.awt.Color(255, 255, 255));
        btSearchMuonSach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/search.png"))); // NOI18N
        btSearchMuonSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSearchMuonSachActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel17Layout = new javax.swing.GroupLayout(jPanel17);
        jPanel17.setLayout(jPanel17Layout);
        jPanel17Layout.setHorizontalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel17Layout.createSequentialGroup()
                        .addComponent(txtSearchMuonSach, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btSearchMuonSach, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel17Layout.setVerticalGroup(
            jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel17Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel17Layout.createSequentialGroup()
                        .addGroup(jPanel17Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtSearchMuonSach, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btSearchMuonSach, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel18, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel8, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        tbMuonSach.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbMuonSach.setAutoscrolls(false);
        tbMuonSach.setFocusable(false);
        tbMuonSach.setMaximumSize(new java.awt.Dimension(1000, 1000));
        tbMuonSach.setPreferredSize(new java.awt.Dimension(1000, 1000));
        tbMuonSach.setRowHeight(25);
        tbMuonSach.setSelectionBackground(new java.awt.Color(241, 57, 83));
        jScrollPane5.setViewportView(tbMuonSach);

        btRefreshMuonSach.setBackground(new java.awt.Color(255, 255, 255));
        btRefreshMuonSach.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btRefreshMuonSach.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/update.png"))); // NOI18N
        btRefreshMuonSach.setText("Refresh");
        btRefreshMuonSach.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btRefreshMuonSachActionPerformed(evt);
            }
        });

        jLabel2.setBackground(new java.awt.Color(0, 204, 153));
        jLabel2.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("   Mượn / Trả");
        jLabel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 102), 2));
        jLabel2.setOpaque(true);

        javax.swing.GroupLayout MuonTraPnLayout = new javax.swing.GroupLayout(MuonTraPn);
        MuonTraPn.setLayout(MuonTraPnLayout);
        MuonTraPnLayout.setHorizontalGroup(
            MuonTraPnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MuonTraPnLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MuonTraPnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MuonTraPnLayout.createSequentialGroup()
                        .addGroup(MuonTraPnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btRefreshMuonSach)
                            .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(100, 100, 100))
        );
        MuonTraPnLayout.setVerticalGroup(
            MuonTraPnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MuonTraPnLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(MuonTraPnLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(MuonTraPnLayout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btRefreshMuonSach))
                    .addComponent(jPanel17, javax.swing.GroupLayout.PREFERRED_SIZE, 298, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 278, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout muonTraPanelLayout = new javax.swing.GroupLayout(muonTraPanel);
        muonTraPanel.setLayout(muonTraPanelLayout);
        muonTraPanelLayout.setHorizontalGroup(
            muonTraPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1010, Short.MAX_VALUE)
            .addGroup(muonTraPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(muonTraPanelLayout.createSequentialGroup()
                    .addComponent(MuonTraPn, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        muonTraPanelLayout.setVerticalGroup(
            muonTraPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 615, Short.MAX_VALUE)
            .addGroup(muonTraPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(muonTraPanelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(MuonTraPn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        contentPanel.add(muonTraPanel, "card4");

        javax.swing.GroupLayout thongKePanelLayout = new javax.swing.GroupLayout(thongKePanel);
        thongKePanel.setLayout(thongKePanelLayout);
        thongKePanelLayout.setHorizontalGroup(
            thongKePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 936, Short.MAX_VALUE)
        );
        thongKePanelLayout.setVerticalGroup(
            thongKePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 604, Short.MAX_VALUE)
        );

        contentPanel.add(thongKePanel, "card5");

        taiKhoanPanel.setBackground(new java.awt.Color(255, 255, 255));

        jPanel7.setBackground(new java.awt.Color(204, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 102)));

        jLabel24.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel24.setText("Tên đăng nhập :");

        jLabel25.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel25.setText("Họ và Tên :");

        jLabel26.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel26.setText("Email :");

        jLabel27.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel27.setText("Số điện thoại :");

        jLabel28.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel28.setText("Thay đổi mật khẩu :");

        jLabel29.setFont(new java.awt.Font("Calibri", 0, 16)); // NOI18N
        jLabel29.setText("Nhập lại mật khẩu :");

        lbTenDN.setFont(new java.awt.Font("Calibri", 0, 15)); // NOI18N

        btSuaTTTK.setBackground(new java.awt.Color(255, 255, 255));
        btSuaTTTK.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btSuaTTTK.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/content.png"))); // NOI18N
        btSuaTTTK.setText("Chỉnh sửa thông tin");
        btSuaTTTK.setIconTextGap(15);
        btSuaTTTK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSuaTTTKActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/portfolio.png"))); // NOI18N
        jButton2.setText("Thay đổi mật khẩu");
        jButton2.setIconTextGap(18);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        btDangXuat.setBackground(new java.awt.Color(255, 255, 255));
        btDangXuat.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btDangXuat.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/logout.png"))); // NOI18N
        btDangXuat.setText("Đăng xuất");
        btDangXuat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDangXuatActionPerformed(evt);
            }
        });

        btTaoMoiTaiKhoan.setBackground(new java.awt.Color(255, 255, 255));
        btTaoMoiTaiKhoan.setFont(new java.awt.Font("Calibri", 0, 14)); // NOI18N
        btTaoMoiTaiKhoan.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/add.png"))); // NOI18N
        btTaoMoiTaiKhoan.setText("Tạo tài khoản mới");
        btTaoMoiTaiKhoan.setIconTextGap(18);
        btTaoMoiTaiKhoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btTaoMoiTaiKhoanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(64, 64, 64)
                        .addComponent(jLabel24)
                        .addGap(23, 23, 23)
                        .addComponent(lbTenDN, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(jLabel25)
                        .addGap(23, 23, 23)
                        .addComponent(txtHoTenThuThu, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(125, 125, 125)
                        .addComponent(jLabel26)
                        .addGap(23, 23, 23)
                        .addComponent(txtEmailThuThu, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(jLabel28)
                        .addGap(23, 23, 23)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btSuaTTTK, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                            .addComponent(txtThayDoiMK)))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jLabel29)
                        .addGap(23, 23, 23)
                        .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNhapLaiMK, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel7Layout.createSequentialGroup()
                                .addComponent(btTaoMoiTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(132, 132, 132)
                                .addComponent(btDangXuat))))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(jLabel27)
                        .addGap(23, 23, 23)
                        .addComponent(txtSoDTThuThu, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel24))
                    .addComponent(lbTenDN, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel25))
                    .addComponent(txtHoTenThuThu, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel26))
                    .addComponent(txtEmailThuThu, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel27))
                    .addComponent(txtSoDTThuThu, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addComponent(btSuaTTTK, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel28))
                    .addComponent(txtThayDoiMK, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(15, 15, 15)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(jLabel29))
                    .addComponent(txtNhapLaiMK, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btDangXuat)
                    .addComponent(btTaoMoiTaiKhoan, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );

        jPanel11.setBackground(new java.awt.Color(255, 255, 255));
        jPanel11.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 102, 102), 2));

        jLabel41.setBackground(new java.awt.Color(255, 102, 102));
        jLabel41.setFont(new java.awt.Font("Calibri", 0, 18)); // NOI18N
        jLabel41.setForeground(new java.awt.Color(255, 255, 255));
        jLabel41.setText("     Tài khoản   ");
        jLabel41.setOpaque(true);

        jLabel42.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Image/tk.png"))); // NOI18N

        javax.swing.GroupLayout jPanel11Layout = new javax.swing.GroupLayout(jPanel11);
        jPanel11.setLayout(jPanel11Layout);
        jPanel11Layout.setHorizontalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel41, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel42)
                .addGap(18, 18, 18))
        );
        jPanel11Layout.setVerticalGroup(
            jPanel11Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel11Layout.createSequentialGroup()
                .addComponent(jLabel42, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel41))
        );

        javax.swing.GroupLayout taiKhoanPanelLayout = new javax.swing.GroupLayout(taiKhoanPanel);
        taiKhoanPanel.setLayout(taiKhoanPanelLayout);
        taiKhoanPanelLayout.setHorizontalGroup(
            taiKhoanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(taiKhoanPanelLayout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 829, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, taiKhoanPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(115, 115, 115))
        );
        taiKhoanPanelLayout.setVerticalGroup(
            taiKhoanPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(taiKhoanPanelLayout.createSequentialGroup()
                .addComponent(jPanel11, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(50, Short.MAX_VALUE))
        );

        contentPanel.add(taiKhoanPanel, "card6");

        javax.swing.GroupLayout containerPanelLayout = new javax.swing.GroupLayout(containerPanel);
        containerPanel.setLayout(containerPanelLayout);
        containerPanelLayout.setHorizontalGroup(
            containerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(containerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(menuPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(contentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 940, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        containerPanelLayout.setVerticalGroup(
            containerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, containerPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(containerPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(menuPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(contentPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(containerPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(containerPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void loadDocGia(){
        mdtbDocgia = new DefaultTableModel();
        mdcbbMaTheMS = new DefaultComboBoxModel();
        mdtbDocgia.addColumn("Mã thẻ");
        mdtbDocgia.addColumn("Họ và Tên");
        mdtbDocgia.addColumn("Phái");
        mdtbDocgia.addColumn("SDT");
        mdtbDocgia.addColumn("Địa chỉ"); 
        mdtbDocgia.addColumn("Ngày cấp");
        mdtbDocgia.addColumn("Ngày hết hạn");
        tbDocGia.getTableHeader().setFont(new Font("Calibri", Font.PLAIN, 16));
        tbDocGia.getTableHeader().setForeground(Color.blue);
        DocGia_Dao dg = new DocGia_Dao();
        ArrayList<DocGia_Pojo> listdg = dg.layDsDocGia();
        mdtbDocgia.setRowCount(0);
        for(DocGia_Pojo d:listdg ){
            Vector<Object> vec = new Vector<Object>();
            vec.add(d.getMaThe());
            vec.add(d.getTenDocGia());
            vec.add(d.getPhai());
            vec.add(d.getSoDT());
            vec.add(d.getDiaChi());
            vec.add(d.getNgayCap());
            vec.add(d.getNgayHetHan());
            mdcbbMaTheMS.addElement(d);
            mdtbDocgia.addRow(vec);
        }
        tbDocGia.setModel(mdtbDocgia);
        cbbMaTheMuonSach.setModel(mdcbbMaTheMS);
      
        TableColumn col = tbDocGia.getColumnModel().getColumn(1);
        col.setPreferredWidth(150);
        tbDocGia.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(e.getValueIsAdjusting() == false){
                    int index = tbDocGia.getSelectedRow();
                    if(index < 0 ){
                        btXoaDocGia.setEnabled(false);
                        btSuaDocGia.setEnabled(false);
                        btgiaHanThe.setEnabled(false);
                        return;
                    }
                    btXoaDocGia.setEnabled(true);
                    btSuaDocGia.setEnabled(true);
                    btgiaHanThe.setEnabled(true);
                    txtMaTheTV.setText((String) mdtbDocgia.getValueAt(index, 0));
                    txtHoTenDG.setText((String) mdtbDocgia.getValueAt(index, 1));
                    if(mdtbDocgia.getValueAt(index, 2).toString().compareTo("Nam") == 0){
                        rdbPhaiNamDG.setSelected(true);
                    }
                    else
                    {
                        rdbNuDG.setSelected(true);
                    }
                    txtSoDTDG.setText((String) mdtbDocgia.getValueAt(index, 3));
                    txtDiaChiDG.setText((String) mdtbDocgia.getValueAt(index, 4));
                    txtNgayCap.setText(String.valueOf( mdtbDocgia.getValueAt(index, 5)));
                    txtNgayHetHan.setText(String.valueOf(mdtbDocgia.getValueAt(index, 6)));
                }
            }
        });
    }
    public void loadSach(){
        mdtbSach = new DefaultTableModel();
        mdcbbMaSachMS = new DefaultComboBoxModel();
        mdtbSach.addColumn("Mã sách");
        mdtbSach.addColumn("Tên sách");
        mdtbSach.addColumn("Mã loại");
        mdtbSach.addColumn("Số lượng");
        mdtbSach.addColumn("Nhà xuất bản");
        mdtbSach.addColumn("Năm xuất bản");
        mdtbSach.addColumn("Tác giả");
        tbSach.getTableHeader().setFont(new Font("Calibri", Font.PLAIN, 16));
        tbSach.getTableHeader().setForeground(Color.blue);
        Sach_Dao sd = new Sach_Dao();
        ArrayList<Sach_Pojo> lists = sd.layDSSach();
        mdtbSach.setRowCount(0);
        for(Sach_Pojo s:lists ){
            Vector<Object> vec = new Vector<Object>();
            vec.add(s.getMaSH());
            vec.add(s.getTenSH());
            vec.add(s.getMaLoai());
            vec.add(s.getSoLuong());
            vec.add(s.getNhaXB());
            vec.add(s.getNamXB());
            vec.add(s.getTacGia());
            mdcbbMaSachMS.addElement(s);
            mdtbSach.addRow(vec);
        }
        tbSach.setModel(mdtbSach);
        cbbMaSachMuonSach.setModel(mdcbbMaSachMS);
        
        tbSach.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                 if(e.getValueIsAdjusting() == false){
                     int index = tbSach.getSelectedRow();
                     if(index < 0){
                         bttXoaSach.setEnabled(false);
                         bttSuaSach.setEnabled(false);
                         return;
                     }
                      bttXoaSach.setEnabled(true);
                      bttSuaSach.setEnabled(true);
                     txtmasach.setText((String) mdtbSach.getValueAt(index, 0));
                     txttensach.setText((String) mdtbSach.getValueAt(index, 1));
                     TheLoaiSach_Dao tls = new TheLoaiSach_Dao();
                     mdcbbMaTheLoaiSach.setSelectedItem(tls.layTheLoaiSach1((String) mdtbSach.getValueAt(index, 2)));
                     txtsoluong.setText(String.valueOf(mdtbSach.getValueAt(index, 3)));
                     txtnxb.setText((String) mdtbSach.getValueAt(index, 4));
                     txtnamxb.setText(String.valueOf( mdtbSach.getValueAt(index, 5)));
                     txttacgia.setText((String) mdtbSach.getValueAt(index, 6));
                 }
            }
        });
    }
    
    public void loadTaiKhoan(){
        TaiKhoan_Dao tk = new TaiKhoan_Dao();
        ThuThu_Pojo tt = tk.layThongTinThuThu(this.tenDN);
        lbTenDN.setText(tt.getTaiKhoan().getTenDN());
        txtHoTenThuThu.setText(tt.getHoTen());
        txtEmailThuThu.setText(tt.getTaiKhoan().getEmail());
        txtSoDTThuThu.setText(tt.getSoDT());
    }
    public void loadMuonSach(){
        mdtbMuonSach = new DefaultTableModel();
        lbMaThuThuMuonSach.setText(this.maThuThu);
        mdtbMuonSach.addColumn("Mã thẻ");
        mdtbMuonSach.addColumn("Mã sách");
        mdtbMuonSach.addColumn("Mã TT");
        mdtbMuonSach.addColumn("Ngày mượn");
        mdtbMuonSach.addColumn("Ngày trả");
        mdtbMuonSach.addColumn("Hạn trả");
        mdtbMuonSach.addColumn("Tình trạng");
        mdtbMuonSach.addColumn("Tiền phạt");
        mdtbMuonSach.addColumn("Ghi chú");
        tbMuonSach.getTableHeader().setFont(new Font("Calibri", Font.PLAIN, 16));
        tbMuonSach.getTableHeader().setForeground(Color.blue);
        MuonSach_Dao ms = new MuonSach_Dao();
        ArrayList<MuonSach_Pojo> lists = ms.layDsMuonSach();
        mdtbMuonSach.setRowCount(0);
        for(MuonSach_Pojo s:lists ){
            Vector<Object> vec = new Vector<Object>();
            vec.add(s.getMaThe());
            vec.add(s.getMaSach());
            vec.add(s.getMaThuThu());
            vec.add(s.getNgayMuon());
            vec.add(s.getNgayTra());
            vec.add(s.getHanTra());
            vec.add(s.getTinhTrang());
            vec.add(s.getTienPhat());
            vec.add(s.getGhiChu());
            mdtbMuonSach.addRow(vec);
        }
        tbMuonSach.setModel(mdtbMuonSach);
        for(int i=0;i<6;i++)
        {
            TableColumn col = tbMuonSach.getColumnModel().getColumn(i);
            col.setPreferredWidth(50);
        }
        tbMuonSach.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if(e.getValueIsAdjusting() == false){
                     int index = tbMuonSach.getSelectedRow();
                     if(index < 0){
                         btXoaMuonSach.setEnabled(false);
                         btSuaMuonSach.setEnabled(false);
                         btKiemTraMuonSach.setEnabled(false);
                         btTraSachMuonSach.setEnabled(false);
                         txtNgayMuonMuonSach.setEnabled(false);
                         txtNgayTraMuonSach.setEnabled(false);
                         txtHanTraMuonSach.setEnabled(false);
                         txtTienPhatMuonSach.setEnabled(false);
                         txtTrinhTrangMuonSach.setEnabled(false);
                         return;
                     }
                      btXoaMuonSach.setEnabled(true);
                      btSuaMuonSach.setEnabled(true);
                      btKiemTraMuonSach.setEnabled(true);
                      btTraSachMuonSach.setEnabled(true);
                      txtNgayMuonMuonSach.setEnabled(true);
                         txtNgayTraMuonSach.setEnabled(true);
                         txtHanTraMuonSach.setEnabled(true);
                         txtTienPhatMuonSach.setEnabled(true);
                         txtTrinhTrangMuonSach.setEnabled(true);
                     txtNgayMuonMuonSach.setText(String.valueOf(mdtbMuonSach.getValueAt(index, 3)));
                     txtNgayTraMuonSach.setText(String.valueOf(mdtbMuonSach.getValueAt(index, 4)));
                     txtHanTraMuonSach.setText(String.valueOf(mdtbMuonSach.getValueAt(index, 5)));
                     txtTienPhatMuonSach.setText(String.valueOf(mdtbMuonSach.getValueAt(index, 7)));
                     txtTrinhTrangMuonSach.setText(String.valueOf(mdtbMuonSach.getValueAt(index, 6)));
                     txtGhiChuMuonSach.setText((String) mdtbMuonSach.getValueAt(index, 8));
                     DocGia_Dao dg = new DocGia_Dao();
                     mdcbbMaTheMS.setSelectedItem(dg.layDocGia1((String) mdtbMuonSach.getValueAt(index, 0)));
                     Sach_Dao s = new Sach_Dao();
                     mdcbbMaSachMS.setSelectedItem(s.laySach1((String) mdtbMuonSach.getValueAt(index, 1)));
                 }
                
            }
        });
    }

    private void btMuonTraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btMuonTraActionPerformed
        // TODO add your handling code here:
        contentPanel.removeAll();
        contentPanel.repaint();
        contentPanel.revalidate();
        
        contentPanel.add(muonTraPanel);
        contentPanel.repaint();
        contentPanel.revalidate();
        loadDocGia();
        loadSach();
        loadMuonSach();
    }//GEN-LAST:event_btMuonTraActionPerformed

    private void btSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSachActionPerformed
        // TODO add your handling code here:
        contentPanel.removeAll();
        contentPanel.repaint();
        contentPanel.revalidate();
        
        contentPanel.add(sachPanel);
        contentPanel.repaint();
        contentPanel.revalidate();
        loadTheLoaiSach();
        loadSach();
    }//GEN-LAST:event_btSachActionPerformed

    private void btDocGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDocGiaActionPerformed
        // TODO add your handling code here:
        contentPanel.removeAll();
        contentPanel.repaint();
        contentPanel.revalidate();
        
        contentPanel.add(docGiaPanel);
        contentPanel.repaint();
        contentPanel.revalidate();
        loadDocGia();
    }//GEN-LAST:event_btDocGiaActionPerformed

    private void btThongKeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThongKeActionPerformed
        // TODO add your handling code here:
        contentPanel.removeAll();
        contentPanel.repaint();
        contentPanel.revalidate();
        
        
        
        MuonSach_Dao msd = new MuonSach_Dao();
        
        ResultSet rs = msd.thongKeMuonSach();
        DefaultCategoryDataset dataset = new DefaultCategoryDataset( );
        try {
            while(rs.next())
               dataset.addValue(rs.getInt(2), "Tốc độ tăng trưởng", rs.getString(1));   
        } catch (SQLException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        JFreeChart lineChart = ChartFactory.createLineChart("Thống kê số lượng sách mượn theo tháng","Năm 2020","Số lượng sách mượn",dataset,PlotOrientation.VERTICAL,true,true,false);
        ChartPanel pn = new ChartPanel(lineChart);
        contentPanel.add(thongKePanel.add(pn));
        contentPanel.repaint();
        contentPanel.revalidate();
    }//GEN-LAST:event_btThongKeActionPerformed

    private void btSachMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSachMouseEntered
        // TODO add your handling code here:
        btSach.setForeground(Color.decode("#3366FF"));
    }//GEN-LAST:event_btSachMouseEntered

    private void btSachMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btSachMouseExited
        // TODO add your handling code here:
        btSach.setForeground(Color.black);
    }//GEN-LAST:event_btSachMouseExited

    private void btDocGiaMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btDocGiaMouseEntered
        // TODO add your handling code here:
        btDocGia.setForeground(Color.decode("#3366FF"));
    }//GEN-LAST:event_btDocGiaMouseEntered

    private void btDocGiaMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btDocGiaMouseExited
        // TODO add your handling code here:
        btDocGia.setForeground(Color.BLACK);
    }//GEN-LAST:event_btDocGiaMouseExited

    private void btMuonTraMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btMuonTraMouseEntered
        // TODO add your handling code here:
        btMuonTra.setForeground(Color.decode("#3366FF"));
    }//GEN-LAST:event_btMuonTraMouseEntered

    private void btMuonTraMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btMuonTraMouseExited
        // TODO add your handling code here:
        btMuonTra.setForeground(Color.BLACK);
    }//GEN-LAST:event_btMuonTraMouseExited

    private void btThongKeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btThongKeMouseEntered
        // TODO add your handling code here:
        btThongKe.setForeground(Color.decode("#3366FF"));
    }//GEN-LAST:event_btThongKeMouseEntered

    private void btThongKeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btThongKeMouseExited
        // TODO add your handling code here:
        btThongKe.setForeground(Color.BLACK);
    }//GEN-LAST:event_btThongKeMouseExited

    private void btTaiKhoanMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btTaiKhoanMouseEntered
        // TODO add your handling code here:
        btTaiKhoan.setForeground(Color.decode("#3366FF"));
    }//GEN-LAST:event_btTaiKhoanMouseEntered

    private void btTaiKhoanMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btTaiKhoanMouseExited
        // TODO add your handling code here:
        btTaiKhoan.setForeground(Color.BLACK);
    }//GEN-LAST:event_btTaiKhoanMouseExited

    private void btTabSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTabSachActionPerformed
        // TODO add your handling code here:
        btTabSach.setForeground(Color.decode("#3366FF"));
        btTabTheLoai.setForeground(Color.black);
        containerSachTheLoai.removeAll();
        containerSachTheLoai.repaint();
        containerSachTheLoai.revalidate();
        
        containerSachTheLoai.add(sachSachPanel);
        containerSachTheLoai.repaint();
        containerSachTheLoai.revalidate();
        
    }//GEN-LAST:event_btTabSachActionPerformed

    private void btTabTheLoaiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTabTheLoaiActionPerformed
        // TODO add your handling code here:
        btTabSach.setForeground(Color.black);
        btTabTheLoai.setForeground(Color.decode("#3366FF"));
        containerSachTheLoai.removeAll();
        containerSachTheLoai.repaint();
        containerSachTheLoai.revalidate();
        
        containerSachTheLoai.add(theLoaiPanel);
        containerSachTheLoai.repaint();
        containerSachTheLoai.revalidate();
    }//GEN-LAST:event_btTabTheLoaiActionPerformed

    private void btRefeshTheLoaiSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRefeshTheLoaiSachActionPerformed
        // TODO add your handling code here:
        loadTheLoaiSach();
        txtMaSach.setText("");
        txtTheLoaiSach.setText("");
        txtBoxSearchTheLoaiSach.setText("");
    }//GEN-LAST:event_btRefeshTheLoaiSachActionPerformed

    private void btThemTheLoaiSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThemTheLoaiSachActionPerformed
        // TODO add your handling code here:
        if(txtTheLoaiSach.getText().isEmpty()){
            JOptionPane.showMessageDialog(getContentPane(), "Vui lòng nhập đầy đủ thông tin!");
            return;
        }
        TheLoaiSach_Dao tlstk = new TheLoaiSach_Dao();
        
        int countTheLoaiSach = 1;
        TheLoaiSach_Dao tls = new TheLoaiSach_Dao();
        ArrayList<String> list = tls.layDsMaTheLoai();
        checkMa(countTheLoaiSach, list);
        while(checkMa(countTheLoaiSach, list) == false){
            countTheLoaiSach +=1;
        }

        String ma ="";
        if(countTheLoaiSach >= 10000){
            ma = String.valueOf("L" + countTheLoaiSach);
        }
        else if(countTheLoaiSach >= 1000){
            ma = String.valueOf("L0" + countTheLoaiSach);
        }
        else if(countTheLoaiSach >= 100){
            ma = String.valueOf("L00" + countTheLoaiSach);
        }
        else if(countTheLoaiSach >= 10){
            ma = String.valueOf("L000" + countTheLoaiSach);
        }
        else{
            ma = String.valueOf("L0000" + countTheLoaiSach);
        }
        
        if(!tlstk.themTheLoaiSach(ma,txtTheLoaiSach.getText())){
            JOptionPane.showMessageDialog(getContentPane(), "Thêm không thành công!");
            return;
        }
        else
        {
            loadTheLoaiSach();
            txtMaSach.setText("");
            txtTheLoaiSach.setText("");
        }
    }//GEN-LAST:event_btThemTheLoaiSachActionPerformed

    private void btXoaTheLoaiSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btXoaTheLoaiSachActionPerformed
        // TODO add your handling code here:
        TheLoaiSach_Dao tlsx = new TheLoaiSach_Dao();
        if(!tlsx.xoaTheLoaiSach((String) mdtb.getValueAt(tbTheLoaiSach.getSelectedRow(), 0))){
            JOptionPane.showMessageDialog(getContentPane(), "Xoá không thành công!");
            return;
        }
        else{
            JOptionPane.showMessageDialog(getContentPane(), "Xoá thành công!");
            loadTheLoaiSach();
            txtMaSach.setText("");
            txtTheLoaiSach.setText("");
        }
    }//GEN-LAST:event_btXoaTheLoaiSachActionPerformed

    private void btSuaTheLoaiSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSuaTheLoaiSachActionPerformed
        // TODO add your handling code here:
        if(txtTheLoaiSach.getText().isEmpty() || txtMaSach.getText().isEmpty()){
            JOptionPane.showMessageDialog(getContentPane(), "Vui lòng nhập thông tin cần sửa!");
            return;
        }
        String maCu = (String) tbTheLoaiSach.getValueAt(tbTheLoaiSach.getSelectedRow(), 0);
        String maMoi=txtMaSach.getText();
        TheLoaiSach_Dao tlss= new TheLoaiSach_Dao();
        if(!tlss.suaTheLoaiSach(maCu,maMoi, txtTheLoaiSach.getText())){
            JOptionPane.showMessageDialog(getContentPane(), "Sửa không thành công!");
            return;
        }
        else{
            loadTheLoaiSach();
            txtMaSach.setText("");
            txtTheLoaiSach.setText("");
        }
    }//GEN-LAST:event_btSuaTheLoaiSachActionPerformed

    private void btSearchTheLoaiSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSearchTheLoaiSachActionPerformed
        // TODO add your handling code here:
        if(txtBoxSearchTheLoaiSach.getText().isEmpty()){
            JOptionPane.showMessageDialog(getContentPane(), "Vui lòng nhập thông tin cần tìm!");
            return;
        }
        TheLoaiSach_Dao tlstk = new TheLoaiSach_Dao();
        ArrayList<TheLoaiSach_Pojo> listttls = tlstk.timKiemTheLoaiSach(txtBoxSearchTheLoaiSach.getText());
        if(listttls.size() == 0){
            JOptionPane.showMessageDialog(getContentPane(), "Không có kết quả cho tìm kiếm này!");
            return;
        }
        mdtb.setRowCount(0);
        for(TheLoaiSach_Pojo s: listttls){
            Vector<Object> vec = new Vector<Object>();
            vec.add(s.getMaLoai());
            vec.add(s.getTheLoai());
            mdtb.addRow(vec);
        }
    }//GEN-LAST:event_btSearchTheLoaiSachActionPerformed

    private void btThemDocGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThemDocGiaActionPerformed
        // TODO add your handling code here:
        if(txtHoTenDG.getText().isEmpty() || (rdbNuDG.isSelected() == false && rdbPhaiNamDG.isSelected() == false) || txtSoDTDG.getText().isEmpty() || txtDiaChiDG.getText().isEmpty()){
            JOptionPane.showMessageDialog(getContentPane(), "Vui lòng nhập / chọn đầy đủ thông tin!");
            return;
        }
        DocGia_Dao dgt = new DocGia_Dao();
    
        int countDocGia = 1;
        DocGia_Dao d = new DocGia_Dao();
        ArrayList<String> list = d.layDsMaDocGia();
        checkMa(countDocGia, list);
        while(checkMa(countDocGia, list) == false){
            countDocGia +=1;
        }
        
        String ma ="";
        if(countDocGia >= 1000){
            ma = String.valueOf("TH" + countDocGia);
        }
        else if(countDocGia >= 100){
            ma = String.valueOf("TH0" + countDocGia);
        }
        else if(countDocGia >= 10){
            ma = String.valueOf("TH00" + countDocGia);
        }
        else{
            ma = String.valueOf("TH000" + countDocGia);
        }
        String phai ="";
        if(rdbNuDG.isSelected()){
            phai = "Nữ";
        }
        else
        {
            phai = "Nam";
        }
        if(!dgt.themDocGia(ma,txtHoTenDG.getText(),phai,txtSoDTDG.getText(),txtDiaChiDG.getText())){
            JOptionPane.showMessageDialog(getContentPane(), "Đăng ký thẻ không thành công!");
            return;
        }
        else
        {
            JOptionPane.showMessageDialog(getContentPane(), "Đăng ký thẻ thành công!");
            loadDocGia();
            txtMaTheTV.setText(null);
            txtHoTenDG.setText(null);
            rdbNuDG.setSelected(false);
            rdbPhaiNamDG.setSelected(false);
            txtSoDTDG.setText(null);
            txtDiaChiDG.setText(null);
            txtNgayCap.setText(null);
            txtNgayHetHan.setText(null);
        }
        
        
   
    }//GEN-LAST:event_btThemDocGiaActionPerformed

    private void btXoaDocGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btXoaDocGiaActionPerformed
        // TODO add your handling code here:
        DocGia_Dao dgx = new DocGia_Dao();
        if(!(dgx.xoaDocGia((String) mdtbDocgia.getValueAt(tbDocGia.getSelectedRow(), 0)))){
            JOptionPane.showMessageDialog(getContentPane(), "Xoá thẻ không thành công!");
            return;
        }
        else{
            JOptionPane.showMessageDialog(getContentPane(), "Xóa thẻ thành công!");
            loadDocGia();
            txtMaTheTV.setText(null);
            txtHoTenDG.setText(null);
            rdbNuDG.setSelected(false);
            rdbPhaiNamDG.setSelected(false);
            txtSoDTDG.setText(null);
            txtDiaChiDG.setText(null);
            txtNgayCap.setText(null);
            txtNgayHetHan.setText(null);
        }
        
    }//GEN-LAST:event_btXoaDocGiaActionPerformed

    private void btSuaDocGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSuaDocGiaActionPerformed
        // TODO add your handling code here:
        if(txtHoTenDG.getText().isEmpty() || (rdbNuDG.isSelected() == false && rdbPhaiNamDG.isSelected() == false) || txtSoDTDG.getText().isEmpty() || txtDiaChiDG.getText().isEmpty()){
            JOptionPane.showMessageDialog(getContentPane(), "Vui lòng nhập thông tin cần sửa!");
            return;
        }
        String maThe = (String) mdtbDocgia.getValueAt(tbDocGia.getSelectedRow(), 0);
        
        String phai ="";
        if(rdbNuDG.isSelected()){
            phai = "Nữ";
        }
        else
        {
            phai = "Nam";
        }
        
        DocGia_Dao dgx = new DocGia_Dao();
        if(!(dgx.suaDocGia(maThe,txtHoTenDG.getText(), phai, txtSoDTDG.getText(), txtDiaChiDG.getText()))){
            JOptionPane.showMessageDialog(getContentPane(), "Sửa không thành công!");
            return;
        }
        else{
            loadDocGia();
            txtMaTheTV.setText(null);
            txtHoTenDG.setText(null);
            rdbNuDG.setSelected(false);
            rdbPhaiNamDG.setSelected(false);
            txtSoDTDG.setText(null);
            txtDiaChiDG.setText(null);
            txtNgayCap.setText(null);
            txtNgayHetHan.setText(null);
        }
        
        
    }//GEN-LAST:event_btSuaDocGiaActionPerformed

    private void btRefeshDocGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRefeshDocGiaActionPerformed
        // TODO add your handling code here:
       loadDocGia();
       txtMaTheTV.setText(null);
       txtHoTenDG.setText(null);
       rdbNuDG.setSelected(false);
       rdbPhaiNamDG.setSelected(false);
       txtSoDTDG.setText(null);
       txtDiaChiDG.setText(null);
       txtNgayCap.setText(null);
       txtNgayHetHan.setText(null);
    }//GEN-LAST:event_btRefeshDocGiaActionPerformed

    private void btSearchDocGiaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSearchDocGiaActionPerformed
        // TODO add your handling code here:
        if(txtBoxSearchDocGia.getText().isEmpty()){
            JOptionPane.showMessageDialog(getContentPane(), "Vui lòng nhập thông tin cần tìm!");
            return;
        }
        DocGia_Dao dgtk = new DocGia_Dao();
        ArrayList<DocGia_Pojo> listdgtk = dgtk.timKiemDocGia(txtBoxSearchDocGia.getText());
        if(listdgtk.size() == 0){
            JOptionPane.showMessageDialog(getContentPane(), "Không có kết quả cho tìm kiếm này!");
            return;
        }
        mdtbDocgia.setRowCount(0);
        for(DocGia_Pojo d: listdgtk){
            Vector<Object> vec = new Vector<Object>();
            vec.add(d.getMaThe());
            vec.add(d.getTenDocGia());
            vec.add(d.getPhai());
            vec.add(d.getSoDT());
            vec.add(d.getDiaChi());
            vec.add(d.getNgayCap());
            vec.add(d.getNgayHetHan());
            mdtbDocgia.addRow(vec);
        }
        
    }//GEN-LAST:event_btSearchDocGiaActionPerformed

    private void btgiaHanTheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btgiaHanTheActionPerformed
        // TODO add your handling code here:
        
        DocGia_Dao ght = new DocGia_Dao();
        if(!(ght.giaHanThe((String) mdtbDocgia.getValueAt(tbDocGia.getSelectedRow(), 0)))){
            JOptionPane.showMessageDialog(getContentPane(), "Gia hạn thẻ không thành công!");
            return;
        }
        else
        {
            JOptionPane.showMessageDialog(getContentPane(), "Gia hạn thẻ thành công!");
            loadDocGia();
            txtMaTheTV.setText(null);
            txtHoTenDG.setText(null);
            rdbNuDG.setSelected(false);
            rdbPhaiNamDG.setSelected(false);
            txtSoDTDG.setText(null);
            txtDiaChiDG.setText(null);
            txtNgayCap.setText(null);
            txtNgayHetHan.setText(null);
        }
    }//GEN-LAST:event_btgiaHanTheActionPerformed

    private void btDSTheHetHanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDSTheHetHanActionPerformed
        // TODO add your handling code here:
        DocGia_Dao thh = new DocGia_Dao();
        ArrayList<DocGia_Pojo> listthh = thh.layDSTheHetHan();
        if(listthh.size() == 0){
            JOptionPane.showMessageDialog(getContentPane(), "Không có thẻ hết hạn!");
            return;
        }
        mdtbDocgia.setRowCount(0);
        for(DocGia_Pojo d: listthh){
            Vector<Object> vec = new Vector<Object>();
            vec.add(d.getMaThe());
            vec.add(d.getTenDocGia());
            vec.add(d.getPhai());
            vec.add(d.getSoDT());
            vec.add(d.getDiaChi());
            vec.add(d.getNgayCap());
            vec.add(d.getNgayHetHan());
            mdtbDocgia.addRow(vec);
        }
            txtMaTheTV.setText(null);
            txtHoTenDG.setText(null);
            rdbNuDG.setSelected(false);
            rdbPhaiNamDG.setSelected(false);
            txtSoDTDG.setText(null);
            txtDiaChiDG.setText(null);
            txtNgayCap.setText(null);
            txtNgayHetHan.setText(null);
    }//GEN-LAST:event_btDSTheHetHanActionPerformed

    private void btTaiKhoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTaiKhoanActionPerformed
        // TODO add your handling code here:
        
        contentPanel.removeAll();
        contentPanel.repaint();
        contentPanel.revalidate();
        
        contentPanel.add(taiKhoanPanel);
        contentPanel.repaint();
        contentPanel.revalidate();
        if(this.quyen == 0){
            btTaoMoiTaiKhoan.setVisible(false);
        }
        loadTaiKhoan();
    }//GEN-LAST:event_btTaiKhoanActionPerformed

    private void bttThemSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttThemSachActionPerformed
        if(txttensach.getText().isEmpty()||txtsoluong.getText().isEmpty()||txtnxb.getText().isEmpty()||txtnamxb.getText().isEmpty()||txttacgia.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(getContentPane(), "Vui lòng nhập đầy đủ thông tin!");
            return;
        }
        try{
            int n = Integer.parseInt(txtsoluong.getText());
            n = Integer.parseInt(txtnamxb.getText());
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(getContentPane(), "Nhập sai kiểu dữ liệu!");
            return;
        }
        Sach_Dao st = new Sach_Dao();
        
        int countSach = 1;
        Sach_Dao s = new Sach_Dao();
        ArrayList<String> list = s.layDsMaSach();
        checkMa(countSach, list);
        while(checkMa(countSach, list) == false){
            countSach +=1;
        }
        
        String ma= "";
        if(countSach >= 1000)
        {
            ma = String.valueOf("SH"+countSach);
        }
        else if(countSach >=100)
        {
            ma = String.valueOf("SH0" + countSach);

        }
        else if(countSach >= 10)
        {
            ma = String.valueOf("SH00" + countSach);
        }
        else
            ma = String.valueOf("SH000" + countSach);
        TheLoaiSach_Pojo tlsn = (TheLoaiSach_Pojo) cbbmaTheLoai.getSelectedItem();
        String maLoai = tlsn.getMaLoai();
        if(!(st.themSach(ma, txttensach.getText(), maLoai, txtsoluong.getText(), txtnxb.getText(), txtnamxb.getText(), txttacgia.getText()))){
            JOptionPane.showMessageDialog(getContentPane(), "Thêm không thành công!");
            return;
        }
        else
        {
            loadSach();
            txtmasach.setText(null);
            txttensach.setText(null);
            cbbmaTheLoai.setSelectedIndex(0);
            txtsoluong.setText(null);
            txtnxb.setText(null);
            txtnamxb.setText(null);
            txttacgia.setText(null);
        }
   
       
    }//GEN-LAST:event_bttThemSachActionPerformed

    private void bttXoaSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttXoaSachActionPerformed
        Sach_Dao sx = new Sach_Dao();
         String ma = (String) mdtbSach.getValueAt(tbSach.getSelectedRow(), 0);
        if(!sx.xoaSach(ma))
        {
            JOptionPane.showMessageDialog(getContentPane(), "Xóa sách không thành công!");
            return;
        }
        else
        {
            JOptionPane.showMessageDialog(getContentPane(), "Xóa sách thành công!");
            loadSach();
            txtmasach.setText(null);
            txttensach.setText(null);
            cbbmaTheLoai.setSelectedIndex(0);
            txtsoluong.setText(null);
            txtnxb.setText(null);
            txtnamxb.setText(null);
            txttacgia.setText(null);
        }
    }//GEN-LAST:event_bttXoaSachActionPerformed

    private void bttSuaSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttSuaSachActionPerformed
        if(txttensach.getText().isEmpty()||txtsoluong.getText().isEmpty()||txtnxb.getText().isEmpty()||txtnamxb.getText().isEmpty()||txttacgia.getText().isEmpty())
        {
            JOptionPane.showMessageDialog(getContentPane(), "Vui lòng nhập đầy đủ thông tin!");
            return;
        }
        try{
            int n = Integer.parseInt(txtsoluong.getText());
            n = Integer.parseInt(txtnamxb.getText());
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(getContentPane(), "Nhập sai kiểu dữ liệu!");
            return;
        }
        Sach_Dao ss = new Sach_Dao();
        TheLoaiSach_Pojo tlsn = (TheLoaiSach_Pojo) cbbmaTheLoai.getSelectedItem();
        String maLoai = tlsn.getMaLoai();
        if(!(ss.suaSach(txtmasach.getText(), txttensach.getText(), maLoai, txtsoluong.getText(), txtnxb.getText(), txtnamxb.getText(), txttacgia.getText()))){
            JOptionPane.showMessageDialog(getContentPane(), "Sửa không thành công!");
            return;
        }
        else
        {
            JOptionPane.showMessageDialog(getContentPane(), "Sửa thành công!");
            loadSach();
            txtmasach.setText(null);
            txttensach.setText(null);
            cbbmaTheLoai.setSelectedIndex(0);
            txtsoluong.setText(null);
            txtnxb.setText(null);
            txtnamxb.setText(null);
            txttacgia.setText(null);
        }
    }//GEN-LAST:event_bttSuaSachActionPerformed

    private void bttSearchSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttSearchSachActionPerformed
        // TODO add your handling code here:
        if(txtSearchSach.getText().isEmpty()){
            JOptionPane.showMessageDialog(getContentPane(), "Vui lòng nhập thông tin cần tìm!");
            return;
        }
        Sach_Dao stk = new Sach_Dao();
        ArrayList<Sach_Pojo> listtks = stk.timKiemSach(txtSearchSach.getText());
        if(listtks.size() == 0){
            JOptionPane.showMessageDialog(getContentPane(), "Không có kết quả cho tìm kiếm này!");
            return;
        }
        mdtbSach.setRowCount(0);
        for(Sach_Pojo s:listtks ){
            Vector<Object> vec = new Vector<Object>();
            vec.add(s.getMaSH());
            vec.add(s.getTenSH());
            vec.add(s.getMaLoai());
            vec.add(s.getSoLuong());
            vec.add(s.getNhaXB());
            vec.add(s.getNamXB());
            vec.add(s.getTacGia());   
            mdtbSach.addRow(vec);
        }
        
        
        
    }//GEN-LAST:event_bttSearchSachActionPerformed

    private void bttRefreshSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bttRefreshSachActionPerformed
        // TODO add your handling code here:
        
            loadSach();
            txtmasach.setText(null);
            txttensach.setText(null);
            cbbmaTheLoai.setSelectedIndex(0);
            txtsoluong.setText(null);
            txtnxb.setText(null);
            txtnamxb.setText(null);
            txttacgia.setText(null);
    }//GEN-LAST:event_bttRefreshSachActionPerformed

    private void btSuaTTTKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSuaTTTKActionPerformed
        // TODO add your handling code here:
        if(txtHoTenThuThu.getText().isEmpty() || txtSoDTThuThu.getText().isEmpty() || txtEmailThuThu.getText().isEmpty()){
            JOptionPane.showMessageDialog(getContentPane(), "Vui lòng nhật đầy đủ thông tin!");
            return;
        }
        TaiKhoan_Dao tk = new TaiKhoan_Dao();
        if(!(tk.suaTaiKhoan(this.tenDN,this.maThuThu, txtHoTenThuThu.getText(), txtEmailThuThu.getText(), txtSoDTThuThu.getText()))){
            JOptionPane.showMessageDialog(getContentPane(), "Chỉnh sửa thông tin không thành công!");
            return;
        }
        else
        {
            JOptionPane.showMessageDialog(getContentPane(), "Chỉnh sửa thông tin thành công!");
            loadTaiKhoan();
        }
        
    }//GEN-LAST:event_btSuaTTTKActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        if(txtThayDoiMK.getText().isEmpty() || txtNhapLaiMK.getText().isEmpty()){
            JOptionPane.showMessageDialog(getContentPane(), "Vui lòng nhập đầy đủ thông tin!");
            return;
        }
        if(txtThayDoiMK.getText().compareTo(txtNhapLaiMK.getText()) != 0){
            JOptionPane.showMessageDialog(getContentPane(), "Password must match!");
            return;
        }
        TaiKhoan_Dao tk = new TaiKhoan_Dao();
        if(!(tk.suaMatKhau(this.tenDN,txtNhapLaiMK.getText() ))){
            JOptionPane.showMessageDialog(getContentPane(), "Thay đổi mật khẩu không thành công!");
            return;
        }
        else
        {
             JOptionPane.showMessageDialog(getContentPane(), "Thay đổi mật khẩu thành công!");
             txtThayDoiMK.setText(null);
             txtNhapLaiMK.setText(null);
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void btDangXuatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDangXuatActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btDangXuatActionPerformed

    private void btTaoMoiTaiKhoanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTaoMoiTaiKhoanActionPerformed
        // TODO add your handling code here:
        new FrameCreateAccount().setVisible(true);
    }//GEN-LAST:event_btTaoMoiTaiKhoanActionPerformed

    private void btTraSachMuonSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btTraSachMuonSachActionPerformed
      
        //String maThe,String maSach,String ngayMuon,String tienPhat,String ghiChu
        String maThe = (String) mdtbMuonSach.getValueAt(tbMuonSach.getSelectedRow(), 0);
        String maSach = (String) mdtbMuonSach.getValueAt(tbMuonSach.getSelectedRow(), 1);
        String ngayMuon = String.valueOf(mdtbMuonSach.getValueAt(tbMuonSach.getSelectedRow(), 3));
        MuonSach_Dao ms = new MuonSach_Dao();
        if(!(ms.traSach(maThe, maSach, ngayMuon, txtTienPhatMuonSach.getText(), txtGhiChuMuonSach.getText()))){
            JOptionPane.showMessageDialog(getContentPane(), "Trả sách không thành công!");
            return;
        }
        else
        {
            JOptionPane.showMessageDialog(getContentPane(), "Trả sách thành công!");
            loadMuonSach();
            return;
        }
    }//GEN-LAST:event_btTraSachMuonSachActionPerformed

    private void btSuaMuonSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSuaMuonSachActionPerformed

        //String maThe,String maSach,String ngayMuon,String hanTra,String tienPhat,String ghiChu
        String maThe = (String) mdtbMuonSach.getValueAt(tbMuonSach.getSelectedRow(), 0);
        String maSach = (String) mdtbMuonSach.getValueAt(tbMuonSach.getSelectedRow(), 1);
        
        MuonSach_Dao ms = new MuonSach_Dao();
        if(!(ms.suaMuonSach(maThe, maSach, txtNgayMuonMuonSach.getText(), txtHanTraMuonSach.getText(), txtTienPhatMuonSach.getText(), txtGhiChuMuonSach.getText()))){
            JOptionPane.showMessageDialog(getContentPane(), "Chỉnh sửa không thành công!");
            return;
        }
        else
        {
            JOptionPane.showMessageDialog(getContentPane(), "Chỉnh sửa thành công!");
            loadMuonSach();
            txtNgayMuonMuonSach.setText(null);
            txtNgayTraMuonSach.setText(null);
            txtHanTraMuonSach.setText(null);
            txtTienPhatMuonSach.setText(null);
             txtTrinhTrangMuonSach.setText(null);
            txtGhiChuMuonSach.setText(null);
            cbbMaSachMuonSach.setSelectedIndex(0);
            cbbMaTheMuonSach.setSelectedIndex(0);
        }
    }//GEN-LAST:event_btSuaMuonSachActionPerformed

    private void btXoaMuonSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btXoaMuonSachActionPerformed

        String maThe = (String) mdtbMuonSach.getValueAt(tbMuonSach.getSelectedRow(), 0);
        String maSach = (String) mdtbMuonSach.getValueAt(tbMuonSach.getSelectedRow(), 1);
        String ngayMuon =  String.valueOf(mdtbMuonSach.getValueAt(tbMuonSach.getSelectedRow(), 3));
        MuonSach_Dao ms = new MuonSach_Dao();
        if(!(ms.xoaMuonSach(maThe, maSach, ngayMuon))){
            JOptionPane.showMessageDialog(getContentPane(), "Xóa không thành công!");
            return;
        }
        else
        {
            JOptionPane.showMessageDialog(getContentPane(), "Xóa thành công!");
            loadMuonSach();
            txtNgayMuonMuonSach.setText(null);
            txtNgayTraMuonSach.setText(null);
            txtHanTraMuonSach.setText(null);
            txtTienPhatMuonSach.setText(null);
             txtTrinhTrangMuonSach.setText(null);
            txtGhiChuMuonSach.setText(null);
            cbbMaSachMuonSach.setSelectedIndex(0);
            cbbMaTheMuonSach.setSelectedIndex(0);
        }
    }//GEN-LAST:event_btXoaMuonSachActionPerformed

    private void btRefreshMuonSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btRefreshMuonSachActionPerformed
        // TODO add your handling code here:
        loadMuonSach();
        txtNgayMuonMuonSach.setText(null);
        txtNgayTraMuonSach.setText(null);
        txtHanTraMuonSach.setText(null);
        txtTienPhatMuonSach.setText(null);
        txtTrinhTrangMuonSach.setText(null);
        txtGhiChuMuonSach.setText(null);
        cbbMaSachMuonSach.setSelectedIndex(0);
        cbbMaTheMuonSach.setSelectedIndex(0);
    }//GEN-LAST:event_btRefreshMuonSachActionPerformed

    private void btSearchMuonSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSearchMuonSachActionPerformed
        // TODO add your handling code here:
        if(txtSearchMuonSach.getText().isEmpty()){
            JOptionPane.showMessageDialog(getContentPane(), "Vui lòng nhập thông tin cần tìm!");
            return;
        }
        MuonSach_Dao ms = new MuonSach_Dao();
        ArrayList<MuonSach_Pojo> lists = ms.timKiemMuonSach(txtSearchMuonSach.getText());
        if(lists.size() == 0){
            JOptionPane.showMessageDialog(getContentPane(), "Không có kết quả cho tìm kiếm này!");
            return;
        }
        mdtbMuonSach.setRowCount(0);
        for(MuonSach_Pojo s:lists ){
            Vector<Object> vec = new Vector<Object>();
            vec.add(s.getMaThe());
            vec.add(s.getMaSach());
            vec.add(s.getMaThuThu());
            vec.add(s.getNgayMuon());
            vec.add(s.getNgayTra());
            vec.add(s.getHanTra());
            vec.add(s.getTinhTrang());
            vec.add(s.getTienPhat());
            vec.add(s.getGhiChu());
            mdtbMuonSach.addRow(vec);
        }
    }//GEN-LAST:event_btSearchMuonSachActionPerformed

    private void btKiemTraMuonSachActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btKiemTraMuonSachActionPerformed
        // TODO add your handling code here:
        String maThe = (String) mdtbMuonSach.getValueAt(tbMuonSach.getSelectedRow(), 0);
        String maSach = (String) mdtbMuonSach.getValueAt(tbMuonSach.getSelectedRow(), 1);
        String ngayMuon =  String.valueOf(mdtbMuonSach.getValueAt(tbMuonSach.getSelectedRow(), 3));
        MuonSach_Dao ms = new MuonSach_Dao();
        
        int n = ms.kiemTraTraSach(maThe, maSach, ngayMuon);
        if(n>0){
            JOptionPane.showMessageDialog(getContentPane(), "Độc giả trả sách quá hạn " + n +" ngày!");
            txtGhiChuMuonSach.setText("Trả sách quá hạn " + n +" ngày");
            return;
        }
        else
        {
            JOptionPane.showMessageDialog(getContentPane(), "Độc giả trả sách đúng hạn!");
            return;
        }
    }//GEN-LAST:event_btKiemTraMuonSachActionPerformed

    private void btThemMuonSach1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btThemMuonSach1ActionPerformed
        // TODO add your handling code here:
        if(cbbMaSachMuonSach.getSelectedIndex() == -1 && cbbMaTheMuonSach.getSelectedIndex() == -1){
            return;
        }
        MuonSach_Dao ms = new MuonSach_Dao();
        DocGia_Pojo dg = (DocGia_Pojo) cbbMaTheMuonSach.getSelectedItem();
        Sach_Pojo sach = (Sach_Pojo) cbbMaSachMuonSach.getSelectedItem();
        if(ms.kiemTraHanThe(dg.getMaThe())){
            JOptionPane.showMessageDialog(getContentPane(), "Thẻ thư viện đã hết hạn!");
            return;
        }
        if(!(ms.themMuonSach(dg.getMaThe(), sach.getMaSH(), this.maThuThu))){
            JOptionPane.showMessageDialog(getContentPane(), "Mượn sách không thành công!");
            return;
        }
        else
        {
            JOptionPane.showMessageDialog(getContentPane(), "Mượn sách thành công!");
            loadMuonSach();
            return;
        }
    }//GEN-LAST:event_btThemMuonSach1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel MuonTraPn;
    private javax.swing.JPanel boxTextControlTheLoaiSach;
    private javax.swing.JPanel boxTextControlTheLoaiSach1;
    private javax.swing.JPanel boxTextFieldTheLoaiSach;
    private javax.swing.JPanel boxTextFieldTheLoaiSach1;
    private javax.swing.JButton btDSTheHetHan;
    private javax.swing.JButton btDangXuat;
    private javax.swing.JButton btDocGia;
    private javax.swing.ButtonGroup btGroupPhaiDocGia;
    private javax.swing.JButton btKiemTraMuonSach;
    private javax.swing.JButton btMuonTra;
    private javax.swing.JButton btRefeshDocGia;
    private javax.swing.JButton btRefeshTheLoaiSach;
    private javax.swing.JButton btRefreshMuonSach;
    private javax.swing.JButton btSach;
    private javax.swing.JButton btSearchDocGia;
    private javax.swing.JButton btSearchMuonSach;
    private javax.swing.JButton btSearchTheLoaiSach;
    private javax.swing.JButton btSuaDocGia;
    private javax.swing.JButton btSuaMuonSach;
    private javax.swing.JButton btSuaTTTK;
    private javax.swing.JButton btSuaTheLoaiSach;
    private javax.swing.JButton btTabSach;
    private javax.swing.JButton btTabTheLoai;
    private javax.swing.JButton btTaiKhoan;
    private javax.swing.JButton btTaoMoiTaiKhoan;
    private javax.swing.JButton btThemDocGia;
    private javax.swing.JButton btThemMuonSach1;
    private javax.swing.JButton btThemTheLoaiSach;
    private javax.swing.JButton btThongKe;
    private javax.swing.JButton btTraSachMuonSach;
    private javax.swing.JButton btXoaDocGia;
    private javax.swing.JButton btXoaMuonSach;
    private javax.swing.JButton btXoaTheLoaiSach;
    private javax.swing.JButton btgiaHanThe;
    private javax.swing.JButton bttRefreshSach;
    private javax.swing.JButton bttSearchSach;
    private javax.swing.JButton bttSuaSach;
    private javax.swing.JButton bttThemSach;
    private javax.swing.JButton bttXoaSach;
    private javax.swing.JComboBox<String> cbbMaSachMuonSach;
    private javax.swing.JComboBox<String> cbbMaTheMuonSach;
    private javax.swing.JComboBox<String> cbbmaTheLoai;
    private javax.swing.JPanel containerPanel;
    private javax.swing.JPanel containerSachTheLoai;
    private javax.swing.JPanel contentPanel;
    private javax.swing.JPanel docGiaPanel;
    private javax.swing.JPanel docGiaPanel2;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel15;
    private javax.swing.JPanel jPanel16;
    private javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel18;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JLabel lbLoGo;
    private javax.swing.JLabel lbMaThuThuMuonSach;
    private javax.swing.JLabel lbTenDN;
    private javax.swing.JPanel menuPanel;
    private javax.swing.JPanel menuSachPanel;
    private javax.swing.JPanel muonTraPanel;
    private javax.swing.JRadioButton rdbNuDG;
    private javax.swing.JRadioButton rdbPhaiNamDG;
    private javax.swing.JPanel sachPanel;
    private javax.swing.JPanel sachSachPanel;
    private javax.swing.JPanel taiKhoanPanel;
    private javax.swing.JTable tbDocGia;
    private javax.swing.JTable tbMuonSach;
    private javax.swing.JTable tbSach;
    private javax.swing.JTable tbTheLoaiSach;
    private javax.swing.JPanel theLoaiPanel;
    private javax.swing.JPanel thongKePanel;
    private javax.swing.JTextField txtBoxSearchDocGia;
    private javax.swing.JTextField txtBoxSearchTheLoaiSach;
    private javax.swing.JTextField txtDiaChiDG;
    private javax.swing.JTextField txtEmailThuThu;
    private javax.swing.JTextArea txtGhiChuMuonSach;
    private javax.swing.JTextField txtHanTraMuonSach;
    private javax.swing.JTextField txtHoTenDG;
    private javax.swing.JTextField txtHoTenThuThu;
    private javax.swing.JTextField txtMaSach;
    private javax.swing.JTextField txtMaTheTV;
    private javax.swing.JTextField txtNgayCap;
    private javax.swing.JTextField txtNgayHetHan;
    private javax.swing.JTextField txtNgayMuonMuonSach;
    private javax.swing.JTextField txtNgayTraMuonSach;
    private javax.swing.JPasswordField txtNhapLaiMK;
    private javax.swing.JTextField txtSearchMuonSach;
    private javax.swing.JTextField txtSearchSach;
    private javax.swing.JTextField txtSoDTDG;
    private javax.swing.JTextField txtSoDTThuThu;
    private javax.swing.JPasswordField txtThayDoiMK;
    private javax.swing.JTextField txtTheLoaiSach;
    private javax.swing.JTextField txtTienPhatMuonSach;
    private javax.swing.JTextField txtTrinhTrangMuonSach;
    private javax.swing.JTextField txtmasach;
    private javax.swing.JTextField txtnamxb;
    private javax.swing.JTextField txtnxb;
    private javax.swing.JTextField txtsoluong;
    private javax.swing.JTextField txttacgia;
    private javax.swing.JTextField txttensach;
    // End of variables declaration//GEN-END:variables
}
