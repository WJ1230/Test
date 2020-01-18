import java.sql.*;

class Oracle_Basic1 {


	private String addInHotfix;


    public static void main(String argv[]) {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");  //�X�ʵ{��-�ĥ|��
            
            //Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");     //�X�ʵ{��-�Ĥ@��: JDBC-ODBC�����?(Java 8 �}�l,�w���A�䴩)
            //�� �]�w-����x-�t�κ޲z�u��-��ƨӷ�?ODBC)
            //-> ��ܨt�θ�ƨӷ��W��->�s�W->��Oracle in XE->���� 
            //-> [Data Source Name(��ƨӷ��W��)\��J:dsn1] [TNS Service Name\���?XE] [User ID\��J:hr] [OK] -> �T�w
        } catch (java.lang.ClassNotFoundException e) {
            System.err.print("ClassNotFoundException: ");
            System.err.println(e.getMessage());
        }

        try {
            Connection con =  DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "DA105", "123456");
            //Connection con =  DriverManager.getConnection("jdbc:odbc:dsn1", "scott", "tiger");  	  	   	

            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * from emp2");

            while (rs.next()) {
                String str1 = rs.getString(1);
                String str2 = rs.getString(2);

                System.out.print(" EMPNO= " + str1);
                System.out.print(" ENAME= " + str2);
                System.out.print("\n");
            }

            con.close();

        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
    }
}