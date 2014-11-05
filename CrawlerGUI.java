/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Crawler_new;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Jovs
 */
public class CrawlerGUI extends javax.swing.JFrame {

    /**
     * Creates new form TaobaoCrawler
     */
    public CrawlerGUI() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(245, 223, 222));
        setBounds(new java.awt.Rectangle(265, 100, 750, 500));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 51, 51));
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("请输入需要抓取的链接（默认是聚划算中家纺类页面链接）：");

        jTextField1.setText("http://ju.taobao.com/jusp/jiajupindao/tp.htm?spm=608.7183233.764795.21.oY5WoX#floor2");
        jTextField1.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                jTextField1FocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField1FocusLost(evt);
            }
        });

        jLabel2.setForeground(new java.awt.Color(51, 51, 51));
        jLabel2.setText("运行信息：");

        jButton1.setFont(new java.awt.Font("微软雅黑", 0, 16)); // NOI18N
        jButton1.setText("开始抓取数据");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format((new Date())));
        jScrollPane1.setViewportView(jTextArea1);

        jLabel5.setFont(new java.awt.Font("宋体", 1, 12)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel5.setText("请选择数据库：");

        jLabel7.setFont(new java.awt.Font("宋体", 1, 12)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel7.setText("请输入表名称：");

        File configFile=new File(".\\conf.txt");
        if(configFile.exists()){
        	try{
        		BufferedReader br=new BufferedReader(new FileReader(configFile));
        		String databaseName=br.readLine();
        		jTextField2.setText(databaseName);
        		String tableName=br.readLine();
        		jTextField3.setText(tableName);
        		br.close();
        	}catch(Exception e){}        	
        }else{
        	jTextField2.setText("D:\\test.mdb");
        	jTextField3.setText("JiaFang");
        }  
        
        jTextField3.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                jTextField3FocusLost(evt);
            }
        });
        jTextField2.setEnabled(false);
        

        jLabel9.setFont(new java.awt.Font("宋体", 0, 13)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(102, 102, 102));
        jLabel9.setText("若表不存在，则自动新建表");

        jButton2.setText("浏览...");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel3.setBackground(new java.awt.Color(250, 229, 228));

        jLabel3.setFont(new java.awt.Font("宋体", 0, 13)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(102, 102, 102));
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel3.setText("南极人（上海）股份有限公司  版权所有 TaobaoCrawler V3.0.1");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap())
            );
            jPanel3Layout.setVerticalGroup(
                jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel3Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addContainerGap())
            );

        jPanel1.setBackground(new java.awt.Color(249, 223, 222));

        jLabel4.setFont(new java.awt.Font("楷体", 1, 32)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(219, 38, 29));
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("数据抓取专用软件");
        jLabel4.setToolTipText("");

        jLabel10.setIcon(new javax.swing.ImageIcon(".\\img\\南极人ico.png")); // NOI18N

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 165, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 339, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jLabel8.setIcon(new javax.swing.ImageIcon(".\\img\\边框.png")); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 198, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(258, 258, 258))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel7)
                                    .addComponent(jLabel5))
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(19, 19, 19)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel9)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(jButton2)))
                                .addGap(94, 94, 94)))
                        .addContainerGap(27, Short.MAX_VALUE))))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 23, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(10, 10, 10)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
    	try{
        	BufferedWriter bw=new BufferedWriter(new FileWriter(".\\conf.txt"));
        	bw.write(jTextField2.getText()+"\n"+jTextField3.getText());
        	bw.close();
    	}catch(Exception e){
    		
    	}
    	
    	if(!jTextField1.getText().startsWith("http://")){
            jTextArea1.setText("请输入合法的URL链接，应以“http://”为开头");
        }else{
        	jTextArea1.append("\n"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format((new Date()))+"  点击操作！");
            /**
             * 1、获得linkList
             * 2、对linkList中的每个连接进行解析，获得所需要的字段加入到数据库中（加入之前先由productId+startTime+endTime判断唯一性）
             */
            try{
                ArrayList<LinkDetails> linkList=(new UseJsoupLinkListGetter(jTextField1.getText())).getLinkList(); 
                System.out.println(linkList.size());
                
                //连接数据
                Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
                String dburl="jdbc:odbc:driver={Microsoft Access Driver (*.mdb, *.accdb)};DBQ="+
                			jTextField2.getText().substring(0, 2)+"\\\\"+jTextField2.getText().substring(3)+";";
    			Connection conn=DriverManager.getConnection(dburl, "","");
                
    			//判断该表是否存在
    			ResultSet rsTables=conn.getMetaData().getTables(null, null, jTextField3.getText().trim(), null);
    			if(!rsTables.next()){//不存在则新建表
    				String sqlCreate="create table "+jTextField3.getText().trim()+"(productId Text,productName Text,shopName Text,"
    						+ "companyName Text,price Double,origPrice Double,discount Double,numberOfPeople Integer,"
    						+ "type Text,startTime Text,endTime Text,picture Text,link Text,updateTime Text,"
    						+ "primary key(productId,startTime,endTime))";
    				PreparedStatement ppstCreate=conn.prepareStatement(sqlCreate);
    				ppstCreate.executeUpdate();
    				ppstCreate.close();
    			}    			
    			rsTables.close();
    			
            	String sqlQuery="select * from "+jTextField3.getText().trim()+" where productId=? and startTime=? and endTime=?";
            	String sqlUpdate="update "+jTextField3.getText().trim()+" set price=?,numberOfPeople=?,updateTime=? where productId=? and startTime=? and endTime=?";
            	String sqlInsert="insert into "+jTextField3.getText().trim()+"(productId,productName,shopName,companyName,price,origPrice,"
            			+ "discount,numberOfPeople,type,startTime,endTime,picture,link,updateTime) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            	ResultSet rs;
            	PreparedStatement ppstQuery=conn.prepareStatement(sqlQuery);
            	PreparedStatement ppstUpdate=conn.prepareStatement(sqlUpdate);
            	PreparedStatement ppstInsert=conn.prepareStatement(sqlInsert);
                for(LinkDetails linkDetails:linkList){
//                	System.out.println(linkDetails.getLink());
                	UseJsoupParser parser=new UseJsoupParser();
                	parser.praseLink(linkDetails);
                	if(parser.getProductName()!=null){
                		ppstQuery.setString(1, parser.getProductId());
                    	ppstQuery.setString(2, parser.getStartTime());
                    	ppstQuery.setString(3, parser.getEndTime());
                    	rs=ppstQuery.executeQuery();
                    	if(rs.next()){//若已存在该行，则检查是否有必要更新numberOfPeople
                    		if(parser.getNumberOfPeople()!=rs.getInt(8)){//若numberOfPeople不一样，则更新；否则，不做任何操作
                    			jTextArea1.append("\n"+"更新数据 (人数) "+linkDetails.getLink());
                    			ppstUpdate.setDouble(1, parser.getPrice());
                        		ppstUpdate.setInt(2, parser.getNumberOfPeople());
                        		ppstUpdate.setString(3, parser.getUpdateTime());
                        		ppstUpdate.setString(4, parser.getProductId());
                        		ppstUpdate.setString(5, parser.getStartTime());
                        		ppstUpdate.setString(6, parser.getEndTime());
                        		ppstUpdate.execute();
                    		}
                    		if(parser.getPrice()!=rs.getDouble(5)){
                    			jTextArea1.append("\n"+"更新数据（价格）  "+linkDetails.getLink());
                    			ppstUpdate.setDouble(1, parser.getPrice());
                        		ppstUpdate.setInt(2, parser.getNumberOfPeople());
                        		ppstUpdate.setString(3, parser.getUpdateTime());
                        		ppstUpdate.setString(4, parser.getProductId());
                        		ppstUpdate.setString(5, parser.getStartTime());
                        		ppstUpdate.setString(6, parser.getEndTime());
                        		ppstUpdate.execute();
                    		}
                    	}else{//否则增加一行
                    		jTextArea1.append("\n"+"添加记录  "+linkDetails.getLink());
                    		ppstInsert.setString(1, parser.getProductId());
                    		ppstInsert.setString(2, parser.getProductName());
                    		ppstInsert.setString(3, parser.getShopName());
                    		ppstInsert.setString(4, parser.getCompanyName());
                    		ppstInsert.setDouble(5, parser.getPrice());
                    		ppstInsert.setDouble(6, parser.getOrigPrice());
                    		ppstInsert.setDouble(7, parser.getDiscount());
                    		ppstInsert.setInt(8, parser.getNumberOfPeople());
                    		ppstInsert.setString(9, parser.getType());
                    		ppstInsert.setString(10, parser.getStartTime());
                    		ppstInsert.setString(11, parser.getEndTime());
                    		ppstInsert.setString(12, parser.getPicture());
                    		ppstInsert.setString(13, parser.getLink());
                    		ppstInsert.setString(14, parser.getUpdateTime());
                    		ppstInsert.execute();
                    	}
                    	rs.close();
                	}
                }
                ppstQuery.close();
                ppstUpdate.close();
                ppstInsert.close();
                conn.close();
                jTextArea1.append("\n"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format((new Date()))+" 抓取完成！");
            }catch(SQLException e){
            	jTextArea1.append("\n"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format((new Date()))+"出现异常："+"“"+e.getMessage()+"”");
            	if(e.getMessage().equals("[Microsoft][ODBC 驱动程序管理器] 无效的字符串或缓冲区长度")){
            		jTextArea1.append("\n"+"抓取中断，请重新点击“开始抓取”！");
            	}else if(e.getMessage().equals("[Microsoft][ODBC 驱动程序管理器] 未发现数据源名称并且未指定默认驱动程序")){
            		jTextArea1.append("\n"+"驱动异常，请确认安装好Access以及其对应JDBC驱动，或与开发人员联系！");
            	}
            	else{
            		jTextArea1.append("\n"+"请输入正确的数据库位置和名称！");
            	}
            }catch(ClassNotFoundException e){
            	jTextArea1.append("\n"+new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format((new Date()))+"出现异常："+"“"+e.getMessage()+"”"+"\n"+"未找到驱动!!!");
            }
            
        }
    }                                        

    private void jTextField1FocusGained(java.awt.event.FocusEvent evt) {                                        
        
    }                                       

    private void jTextField1FocusLost(java.awt.event.FocusEvent evt) {                                      
        if(jTextField1.getText().isEmpty()||jTextField1.getText()==null||jTextField1.getText().trim()==""){
            jTextField1.setText("http://ju.taobao.com/jusp/jiajupindao/tp.htm?spm=608.7183233.764795.21.oY5WoX#floor2");
        }
    }                                     

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        JFileChooser fileChooser = new JFileChooser(jTextField2.getText().substring(0, jTextField2.getText().lastIndexOf("\\")));
        FileNameExtensionFilter filter = new FileNameExtensionFilter("数据库文件(*.mdb&*.aacdb)", "mdb","aacdb");
        fileChooser.setFileFilter(filter);
        int returnVal = fileChooser.showOpenDialog(fileChooser);
        if(returnVal == JFileChooser.APPROVE_OPTION){       
            jTextField2.setText(fileChooser.getSelectedFile().getAbsolutePath());//这个就是你选择的文件夹的路径
    	} 	
    }                                        
    

    private void jTextField3FocusLost(java.awt.event.FocusEvent evt) {                                      
        
    }   
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
            java.util.logging.Logger.getLogger(CrawlerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CrawlerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CrawlerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CrawlerGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CrawlerGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    // End of variables declaration                   
}
