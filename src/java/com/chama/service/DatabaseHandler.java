package com.chama.service;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DatabaseHandler {

    //insert query
    public static int insertAdmin(UserClass user, chamaModel chama) throws SQLException {
        Databaseconnection connection = new Databaseconnection();
        PreparedStatement prepStat = null;
        //create a query

        String query = "INSERT INTO chama_user  (user_name,user_email,user_password,role_type) VALUES " + "(?,?,?,?)";

        try {
            prepStat = connection.connect().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            prepStat.setString(1, user.getUsername());
            prepStat.setString(2, user.getEmailaddress());
            prepStat.setString(3, user.getPassword());
            prepStat.setString(4, user.getRole_type());

            int admin_id = prepStat.executeUpdate();
            int user_id = 0;
            //insert Chama
            if (admin_id == 1) {

                ResultSet rs = prepStat.getGeneratedKeys();
                if (rs.next()) {
                    user_id = rs.getInt(1);

                }

                String chamaquery = "INSERT INTO my_chama (chama_name,admin_id,treasurer_id, date_created) VALUES " + "(?,?,?,?)";
                prepStat = connection.connect().prepareStatement(chamaquery,Statement.RETURN_GENERATED_KEYS);

                prepStat.setString(1, chama.getChamaName());
                prepStat.setInt(2, user_id);
                prepStat.setInt(3, 0);
                prepStat.setDate(4, chama.getDateCreated());

                int chama_id =  prepStat.executeUpdate();
                if(chama_id == 1){
                
            ResultSet rs1 = prepStat.getGeneratedKeys();
            int chamaID  = 0;
            if(rs1.next()){
                chamaID = rs1.getInt(1);
            
            }
          
        String squery = "insert into chama_interests(chama_id,loan_inter,pen_charges,late_repay) values(?,?,?,?)";
        prepStat = connection.connect().prepareStatement(squery);
        prepStat.setInt(1, chamaID);
        prepStat.setInt(2, 1);
        prepStat.setInt(3, 1);
        prepStat.setInt(4, 1);
        
        return prepStat.executeUpdate();
                }
                //create the charges
                
               
                

            }

        } catch (SQLException err) {
            err.printStackTrace();
            return 0;

        } finally {
//			DatabaseUtility.closePreparedStatement(prepStat);
//			connection.disconnect();

        }
        return 0;

    }

    public static String validateUser(UserClass user) {
        //get the user properties
        String username = user.getUsername();
        String password = user.getPassword();
        //String role = user.getRole_type();

        //db values
        String usernameDB;
        String userpassDB;
        String roleDb;
        //create the connection
        Databaseconnection connect = new Databaseconnection();
        PreparedStatement prepstate;
        ResultSet set;

        String query = "select user_name,user_password,role_type from chama_user";
        try {
            prepstate = connect.connect().prepareStatement(query);
            set = prepstate.executeQuery();
            while (set.next()) {
                usernameDB = set.getString("user_name");
                userpassDB = set.getString("user_password");
                roleDb = set.getString("role_type");
                //check agnist the values passed
                if (username.equals(usernameDB) && password.equals(userpassDB) && roleDb.equals("admin")) {
                    return "admin_role";
                } else if (username.equals(usernameDB) && password.equals(userpassDB) && roleDb.equals("treasurer")) {
                    return "treasurer_role";
                }
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return "invalid user credentials,check your username and password";

    }

    public static int adddTreasurer(UserClass user) throws SQLException {
        //create the connections
        Databaseconnection connection = new Databaseconnection();
        PreparedStatement prepStat;
        String query = "insert into chama_user  (user_name,user_email,user_password,role_type) values(?,?,?,?)";

        prepStat = connection.connect().prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        prepStat.setString(1, user.getUsername());
        prepStat.setString(2, user.getEmailaddress());
        prepStat.setString(3, user.getPassword());
        prepStat.setString(4, user.getRole_type());

        int id = prepStat.executeUpdate();

        //get the treasurer generated key
        int treasurerId = 0;

        if (id > 0) {
            ResultSet rs = prepStat.getGeneratedKeys();
            if (rs.next()) {
                treasurerId = rs.getInt(1);

            }

        }

        return treasurerId;

    }

    public static int partAddTrea(int adminID, int treid) throws SQLException {
        //create Database Connection
        Databaseconnection connection = new Databaseconnection();

        String tresquery = "Update my_chama SET treasurer_id = ? where admin_id = ? ";
        PreparedStatement prepStat = connection.connect().prepareStatement(tresquery);
        prepStat.setInt(1, treid);
        prepStat.setInt(2, adminID);

        return prepStat.executeUpdate();

    }
    //create a query to fetch user details

    public static int getUserDetails(String username) throws SQLException {
        Databaseconnection connection = new Databaseconnection();

        String query = "Select user_id from chama_user where user_name = ?";

        PreparedStatement prep = connection.connect().prepareStatement(query);
        prep.setString(1, username);
        ResultSet set = prep.executeQuery();
        int userID = 0;
        while (set.next()) {
            userID = set.getInt("user_id");

        }
        return userID;
    }

    public static int addChamaMember(ChamaMember member, int supervisorID) throws SQLException {
        //create connection
        Databaseconnection connection = new Databaseconnection();
        PreparedStatement prepStat;
        //create query
        String query = "insert into chama_member(first_name,second_name,member_national,member_location,member_email,"
                + "member_phone,chama_supervisor,member_status) values (?,?,?,?,?,?,?,?)";
        prepStat = connection.connect().prepareStatement(query);
        //get the values
        prepStat.setString(1, member.getFirstName());
        prepStat.setString(2, member.getLastName());
        prepStat.setInt(3, member.getIdNumber());
        prepStat.setString(4, member.getLocation());
        prepStat.setString(5, member.getEmailAddress());
        prepStat.setInt(6, member.getPhoneNumber());
        prepStat.setInt(7, supervisorID);
        prepStat.setInt(8, member.getMemberStatus());
        //create the execution
        return prepStat.executeUpdate();

    }

    public static ArrayList<ChamaMember> ShowMembers(int statusCode, int chama_supervisor) throws SQLException {
        //create a connection
        Databaseconnection connection = new Databaseconnection();
        PreparedStatement prepStat;
        //create an arraylist to hold the result set
        ArrayList<ChamaMember> memberList = new ArrayList<>();
        //create String query
        String query = "Select * from chama_member  where member_status = ? and chama_supervisor = ? ";
        prepStat = connection.connect().prepareStatement(query);
        prepStat.setInt(1, statusCode);
        prepStat.setInt(2, chama_supervisor);
        ResultSet set = prepStat.executeQuery();
        while (set.next()) {
            ChamaMember member = new ChamaMember();
            member.setMemberID(set.getInt("member_id"));
            member.setFirstName(set.getString("first_name"));
            member.setLastName(set.getString("second_name"));
            member.setEmailAddress(set.getString("member_email"));
            member.setLocation(set.getString("member_location"));
            member.setIdNumber(set.getInt("member_national"));
            member.setPhoneNumber(set.getInt("member_phone"));
            memberList.add(member);

        }
        return memberList;

    }

    public static int deleteMember(int MemberID, int supervisorID) throws SQLException {
        Databaseconnection connection = new Databaseconnection();
        //create prepared statements
        PreparedStatement prepStat;

        String query = " delete from  chama_member where member_id = ? and chama_supervisor = ?";

        prepStat = connection.connect().prepareStatement(query);
        prepStat.setInt(1, MemberID);
        prepStat.setInt(2, supervisorID);

        return prepStat.executeUpdate();

    }

    public static int modifyMemberStatus(int statusCode, int supervisorID, int treasurerID, int memberNational) throws SQLException {
        Databaseconnection connection = new Databaseconnection();
        //create prepared statements
        PreparedStatement prepStat;
        String query = "update chama_member set member_status = ? , chama_supervisor = ? where member_national = ? and chama_supervisor = ? ";
        prepStat = connection.connect().prepareStatement(query);

        prepStat.setInt(1, statusCode);
        prepStat.setInt(2, supervisorID);
        prepStat.setInt(3, memberNational);
        prepStat.setInt(4, treasurerID);

        return prepStat.executeUpdate();
    }
    //update member details

    public static int modifyMemberDetails(ChamaMember member, int chama_supervisor) throws SQLException {

        Databaseconnection connection = new Databaseconnection();
        //create prepared statements
        PreparedStatement prepStat;

        String query = "update chama_member set first_name = ?, second_name = ?,"
                + " member_location = ?,member_email = ?,member_phone = ? where "
                + "member_national = ? and chama_supervisor = ? ";
        prepStat = connection.connect().prepareStatement(query);
        prepStat.setString(1, member.getFirstName());
        prepStat.setString(2, member.getLastName());
        prepStat.setString(3, member.getLocation());
        prepStat.setString(4, member.getEmailAddress());
        prepStat.setInt(5, member.getPhoneNumber());
        prepStat.setInt(6, member.getIdNumber());
        prepStat.setInt(7, chama_supervisor);
        return prepStat.executeUpdate();
    }
    //get chama treasurer

    public static int getChamaAdmin(int uniqueID) throws SQLException {

        Databaseconnection connection = new Databaseconnection();
        //create prepared statements
        PreparedStatement prepStat;
        //create query
        String query = "select admin_id from my_chama where treasurer_id = ? ";
        prepStat = connection.connect().prepareStatement(query);
        prepStat.setInt(1, uniqueID);

        ResultSet set = prepStat.executeQuery();
        int chamaAdminID = 0;
        while (set.next()) {
            chamaAdminID = set.getInt("admin_id");

        }

        return chamaAdminID;

    }

    public static ArrayList<chamaModel> getChamaDetails(int uniqueID) throws SQLException {
        ArrayList<chamaModel> chamaDetails = new ArrayList<>();

        Databaseconnection connection = new Databaseconnection();
        //create prepared statements
        PreparedStatement prepStat;
        //create query
        String query = "select * from my_chama where treasurer_id = ? or admin_id = ? ";
        prepStat = connection.connect().prepareStatement(query);
        prepStat.setInt(1, uniqueID);
        prepStat.setInt(2, uniqueID);

        ResultSet set = prepStat.executeQuery();
        chamaModel chama = new chamaModel();
        while (set.next()) {
            chama.setChamaID(set.getInt("id"));
            chama.setChamaName(set.getString("chama_name"));
            // chama.getDateCreated(set.getString(""));

            chamaDetails.add(chama);
        }

        return chamaDetails;

    }

    public static int createMemberContribution(ChamaMember member, int treasurer, int chamaID, MemberContribution contribute) throws SQLException {

        Databaseconnection connection = new Databaseconnection();
        //create prepared statements
        PreparedStatement prepStat;

        String query = " insert into chama_contribution (chama_id,member_id,treasurer_id ,amount,contr_status,penalty_status,date_contrib) values (?,?,?,?,?,?,?)";
        prepStat = connection.connect().prepareStatement(query);
        prepStat.setInt(1, chamaID);
        prepStat.setInt(2, member.getIdNumber());
        prepStat.setInt(3, treasurer);
        prepStat.setInt(4, contribute.getAmount());
        prepStat.setInt(5, contribute.getContributeStatus());
        prepStat.setString(6, contribute.getPenaltyStatus());
        prepStat.setDate(7, contribute.getDateCreated());

        //create the execution
        return prepStat.executeUpdate();
    }
    //check if penalty exists

    public static String penaltyExists(ChamaMember member,int chamaID) throws SQLException {

        Databaseconnection connection = new Databaseconnection();
        //create prepared statements
        PreparedStatement prepStat;

        String query = "Select penalty_status from chama_contribution where member_id = ? and chama_id = ? and penalty_status = ? ";

        prepStat = connection.connect().prepareStatement(query);
        prepStat.setInt(1, member.getIdNumber());
        prepStat.setInt(2, chamaID);
        prepStat.setString(3, "true");

        ResultSet set = prepStat.executeQuery();
        String status = "";
        while (set.next()) {

            status = set.getString("penalty_status");

            if (status.equals("no")) {

                return "false";

            }
            if (status.equals("true")) {
                return "true";
            }
            if(status.equals("false")){
            return "false";
            }

        }

        return "false";
    }

    //get the member details
    /*
    
    Fetch data that only belongs to a chama using the natioanl id and chama ID
    
    
    
    
    
    
     */
    public static ArrayList<ChamaMember> ShowMemberDetails(int status, int memberID) throws SQLException {
        //create a connection
        Databaseconnection connection = new Databaseconnection();
        PreparedStatement prepStat;
        //create an arraylist to hold the result set
        ArrayList<ChamaMember> memberList = new ArrayList<>();
        //create String query
        String query = "Select * from chama_member  where member_status = ? and member_national = ?  ";
        prepStat = connection.connect().prepareStatement(query);
        prepStat.setInt(1, status);
        prepStat.setInt(2, memberID);
        ResultSet set = prepStat.executeQuery();
        while (set.next()) {
            ChamaMember member = new ChamaMember();
            member.setMemberID(set.getInt("member_id"));
            member.setFirstName(set.getString("first_name"));
            member.setLastName(set.getString("second_name"));
            member.setEmailAddress(set.getString("member_email"));
            member.setLocation(set.getString("member_location"));
            member.setIdNumber(set.getInt("member_national"));
            member.setPhoneNumber(set.getInt("member_phone"));
            memberList.add(member);

        }
        return memberList;

    }
    //create method to fetch amount contributed by the member

    public static void memberTotalContribution() {

    }
    //get the amount contributed by the member

    public static int getMemberContribution(chamaModel chama, ChamaMember member) throws SQLException {

        // ArrayList<MemberContribution> memberContribute = new ArrayList<>();
        Databaseconnection connection = new Databaseconnection();
        //create prepared statements
        PreparedStatement prepStat;
        //create query
        String query = "select amount from chama_contribution where chama_id = ? and member_id = ?";
        prepStat = connection.connect().prepareStatement(query);

        prepStat.setInt(1, chama.getChamaID());
        prepStat.setInt(2, member.getIdNumber());

        ResultSet set = prepStat.executeQuery();

        int moneyContribute = 0;
        while (set.next()) {
            moneyContribute += set.getInt("amount");

        }

        return moneyContribute;

    }
    //modify member modiication

    public static int modifyMemberContribution(MemberContribution contr, ChamaMember member, int supervsisorID) throws SQLException {

        Databaseconnection connection = new Databaseconnection();
        PreparedStatement prepStat;
        //create String ui
        String query = "update chama_contribution  set amount = ? ,penalty_status = ?, contr_status = ? where member_id = ? and treasurer_id = ?";

        prepStat = connection.connect().prepareStatement(query);
        prepStat.setInt(1, contr.getAmount());
        prepStat.setString(2, contr.getPenaltyStatus());
        prepStat.setInt(3, contr.getContributeStatus());
       
        prepStat.setInt(4, member.getIdNumber());
        prepStat.setInt(5, supervsisorID);
        //create the execution

        return prepStat.executeUpdate();

    }
    //create penalties for members not contributed

    public static void penaliseMembers(MemberContribution mem, int chamaID) throws SQLException {

        Databaseconnection connection = new Databaseconnection();
        PreparedStatement prepStat;
        String query = "update chama_contribution set penalty_status = ? where chama_id = ? and contr_status = ? ";
        prepStat = connection.connect().prepareStatement(query);
        //execute the queries
        prepStat.setString(1, mem.getPenaltyStatus());
        prepStat.setInt(2, chamaID);
        prepStat.setInt(3, mem.getContributeStatus());

        //execute update
        prepStat.executeUpdate();

    }
    //fetch members who have penalties

    public static ArrayList<penaltyModel> getPenalisedMembers(int superv, int contr_status, int charges) throws SQLException {
        Databaseconnection connection = new Databaseconnection();
        PreparedStatement prepStat;
        String query = "select m.first_name as 'member_fname',m.member_national as 'membernational',m.member_id as 'memberuniqueacc',m.second_name as 'member_sname', "
                + "s.date_contrib  as 'date_penal',s.contr_id as 'penalty_id' from chama_contribution  as s inner join chama_member   as m on s.member_id = m.member_national "
                + " where  m.chama_supervisor = ? and s.contr_status = ? group by m.first_name, m.member_national,m.member_id,m.second_name,s.date_contrib,s.contr_id ";
        prepStat = connection.connect().prepareStatement(query);
        prepStat.setInt(1, superv);
        prepStat.setInt(2, contr_status);
        ResultSet set = prepStat.executeQuery();
        // penaltyModel  = new penaltyModel();
        ArrayList<penaltyModel> penalM = new ArrayList<>();
        penaltyModel pen;
        while (set.next()) {
            pen = new penaltyModel();
            // String firstName = set.getString("member_fname");
            //  String secondName = set.getString("member_sname");
            // int memberNational = set.getInt("membernational");
            //int penaltyID = set.getInt("penalty_id");
            //Date dateCreated = set.getDate("date_penal");

            //add the attributes
            pen.setFirstname(set.getString("member_fname"));
            pen.setMemberaccountID(set.getInt("memberuniqueacc"));
            pen.setSecondname(set.getString("member_sname"));
            pen.setDateCreated(set.getString("date_penal"));
            pen.setPenaltyID(set.getInt("penalty_id"));
            pen.setIdnumber(set.getInt("membernational"));
            pen.setAmountCharged(charges);

            penalM.add(pen);

        }

        return penalM;
    }
    //clear penalty

    public static int clearPenalty(MemberContribution contribute, penaltyModel penalt, ChamaMember mem, int treasure) throws SQLException {
        Databaseconnection connection = new Databaseconnection();
        PreparedStatement prepStat;
        String query = "update  chama_contribution set amount = ?,penalty_status = ? , "
                + "contr_status = ? where treasurer_id = ? and contr_id = ? ";
        prepStat = connection.connect().prepareStatement(query);
        prepStat.setInt(1, contribute.getAmount());
        prepStat.setString(2, contribute.getPenaltyStatus());
        prepStat.setInt(3, contribute.getContributeStatus());
        // prepStat.setInt(4,mem.getIdNumber());
        prepStat.setInt(4, treasure);
        prepStat.setInt(5, contribute.getContr_id());
        //execute
        int result = prepStat.executeUpdate();
        int result2 = 0;

        if (result > 0) {
            String quString = "insert into penalty_table (member_id,first_name,second_name,chama_id,datecreated,amountcharged) values (?,?,?,?,?,?)";
            prepStat = connection.connect().prepareStatement(quString);
            prepStat.setInt(1, penalt.getIdnumber());
            prepStat.setString(2, penalt.getFirstname());
            prepStat.setString(3, penalt.getSecondname());
            prepStat.setInt(4, penalt.getChamaID());
            prepStat.setString(5, penalt.getDateCreated());
            prepStat.setInt(6, penalt.getAmountCharged());
            result2 = prepStat.executeUpdate();

        }
        return result2;
    }

//check if loan exists
    public static String LoanExists(ChamaMember member, int supervisorID) throws SQLException {

        Databaseconnection connection = new Databaseconnection();
        //create prepared statements
        PreparedStatement prepStat;

        String query = "Select loan_id from loan_table where member_id = ? and supervisor_id = ?";

        prepStat = connection.connect().prepareStatement(query);
        prepStat.setInt(1, member.getIdNumber());
        prepStat.setInt(2, supervisorID);

        ResultSet set = prepStat.executeQuery();
        int loan = 0;
        while (set.next()) {

            loan = set.getInt("loan_id");

            if (loan > 0) {

                return "true";

            }

        }
        return "false";

    }

    //Create a loan
    public static int createLoan(loanModel loan, ChamaMember member, int supervisorID, int chamaID) throws SQLException {

        Databaseconnection connection = new Databaseconnection();
        //create prepared statements
        PreparedStatement prepStat;

        String query = " insert into loan_table (chama_id,supervisor_id,member_id ,loaned_amount,loan_status,date_created,repay_date) values (?,?,?,?,?,?,?)";
        prepStat = connection.connect().prepareStatement(query);
        prepStat.setInt(1, chamaID);
        prepStat.setInt(2, supervisorID);
        prepStat.setInt(3, member.getIdNumber());
        prepStat.setInt(4, loan.getLoanedAmount());
        prepStat.setInt(5, loan.getLoanStatus());
        prepStat.setDate(6, loan.getDateCreated());
        prepStat.setString(7, loan.getRepayDate());

        //create the execution
        return prepStat.executeUpdate();
    }

    //get the total amount contributed
    public static int getTotalChamaContribution(chamaModel chama) throws SQLException {

        // ArrayList<MemberContribution> memberContribute = new ArrayList<>();
        Databaseconnection connection = new Databaseconnection();
        //create prepared statements
        PreparedStatement prepStat;
        //create query
        String query = "select sum(amount) from chama_contribution where chama_id = ?";
        prepStat = connection.connect().prepareStatement(query);

        prepStat.setInt(1, chama.getChamaID());

        ResultSet set = prepStat.executeQuery();
        String totalAmount = "";
        if (!set.next()) {
            return 0;
        } else {
            totalAmount = set.getString(1);
            if (totalAmount == null) {
                return 0;

            }

            return Integer.parseInt(totalAmount);
        }

    }
    //get the total amount contributed

    public static int getTotalLoans(chamaModel chama) throws SQLException {

        // ArrayList<MemberContribution> memberContribute = new ArrayList<>();
        Databaseconnection connection = new Databaseconnection();
        //create prepared statements
        PreparedStatement prepStat;
        //create query
        String query = "select sum(loaned_amount) from loan_table where chama_id = ?";
        prepStat = connection.connect().prepareStatement(query);

        prepStat.setInt(1, chama.getChamaID());

        ResultSet set = prepStat.executeQuery();
        String totalAmount = "";
        if (!set.next()) {
            return 0;
        } else {
            totalAmount = set.getString(1);
            if (totalAmount == null) {
                return 0;

            }

            return Integer.parseInt(totalAmount);
        }

    }
    
    public static int getMembers(chamaModel chama) throws SQLException {

        // ArrayList<MemberContribution> memberContribute = new ArrayList<>();
        Databaseconnection connection = new Databaseconnection();
        //create prepared statements
        PreparedStatement prepStat;
        //create query
        String query = "select * from chama_member where chama_supervisor = ?";
        prepStat = connection.connect().prepareStatement(query);

        prepStat.setInt(1, chama.getChamaID());

        ResultSet set = prepStat.executeQuery();
        int totalM = 0;
        while (set.next()) {            
            totalM += 1;
        }
return  totalM;
    }

    //get the loan from loan table based on ID
    public static int getIndividualTotalLoans(chamaModel chama, ChamaMember member) throws SQLException {

        // ArrayList<MemberContribution> memberContribute = new ArrayList<>();
        Databaseconnection connection = new Databaseconnection();
        //create prepared statements
        PreparedStatement prepStat;
        //create query
        String query = "select loaned_amount from loan_table where chama_id = ? and  member_id = ? ";
        prepStat = connection.connect().prepareStatement(query);

        prepStat.setInt(1, chama.getChamaID());
        prepStat.setInt(2, member.getIdNumber());

        ResultSet set = prepStat.executeQuery();
        String totalAmount = "";
        if (!set.next()) {
            return 0;
        } else {
            totalAmount = set.getString(1);
            if (totalAmount == null) {
                return 0;

            }

            return Integer.parseInt(totalAmount);
        }

    }

    //approve loans
    public static int approveLoan(chamaModel chama, ChamaMember member, loanModel loan) throws SQLException {
        Databaseconnection connection = new Databaseconnection();
        PreparedStatement prepStat;

        //create String ui
        String query = "update loan_table  set loan_status = ? where member_id = ? and chama_id = ?";
        prepStat = connection.connect().prepareStatement(query);

        prepStat.setInt(1, loan.getLoanStatus());
        prepStat.setInt(2, member.getIdNumber());
        prepStat.setInt(3, chama.getChamaID());

        return prepStat.executeUpdate();

    }
    //view active loans

    public static ArrayList<retrieveLoan> getLoans(chamaModel chama, int loanstatus) throws SQLException {
        Databaseconnection connection = new Databaseconnection();
        PreparedStatement prepStat;
        String query = "select m.first_name as 'member_fname',m.member_national as 'membernational',m.member_id as 'memberuniqueacc',m.second_name as 'member_sname', "
                + "l.date_created  as 'date_loaned',l.loaned_amount  as 'loaned_amount',l.repay_date as 'date_repaid',l.loan_id as 'loan_id' from loan_table  as l inner join chama_member   as m on l.member_id = m.member_national "
                + " where  l.chama_id = ? and l.loan_status = ? group by m.first_name,m.member_national,m.member_id ,m.second_name,l.date_created,l.loaned_amount,l.repay_date,l.loan_id";
        prepStat = connection.connect().prepareStatement(query);
        prepStat.setInt(1, chama.getChamaID());
        prepStat.setInt(2, loanstatus);
        ResultSet set = prepStat.executeQuery();
        // penaltyModel  = new penaltyModel();
        ArrayList<retrieveLoan> retrieveLoan = new ArrayList<>();
        retrieveLoan loan;
        while (set.next()) {
            loan = new retrieveLoan();
            // String firstName = set.getString("member_fname");
            //  String secondName = set.getString("member_sname");
            // int memberNational = set.getInt("membernational");
            //int penaltyID = set.getInt("penalty_id");
            //Date dateCreated = set.getDate("date_penal");

            //add the attributes
            //pen.setFirstname(set.getString("member_fname"));
            loan.setFirstName(set.getString("member_fname"));
            loan.setSecondName(set.getString("member_sname"));
            loan.setMemberidNumber(set.getInt("membernational"));
            loan.setLoanid(set.getInt("loan_id"));
            loan.setLoanedamount(set.getInt("loaned_amount"));
            loan.setDateCreated(set.getString("date_loaned"));
            loan.setDateRepaid(set.getString("date_repaid"));

            retrieveLoan.add(loan);
        }

        return retrieveLoan;
    }

    public static int commitLoan(retrieveLoan loan) throws SQLException {
        Databaseconnection connection = new Databaseconnection();
        PreparedStatement prepStat;
        String query = "insert into loan_charges(loan_id,chama_id,member_id,first_name,second_name,loan_status,repaid_amount,loans_profit,date_repaid) values(?,?,?,?,?,?,?,?,?)";
        prepStat = connection.connect().prepareStatement(query);
        prepStat.setInt(1, loan.getLoanid());
        prepStat.setInt(2, loan.getChamaID());
        prepStat.setInt(3, loan.getMemberidNumber());
        prepStat.setString(4, loan.getFirstName());
        prepStat.setString(5, loan.getSecondName());
        prepStat.setString(6, loan.getLoanStatus());
        prepStat.setInt(7, loan.getLoan_profits());
        prepStat.setInt(8, loan.getLoanedamount());
        prepStat.setDate(9, loan.getRepayDate());

        return prepStat.executeUpdate();

    }
//get the loan for repayment

    public static ArrayList<retrieveLoan> repayLoan(retrieveLoan loan) throws SQLException {

        Databaseconnection connection = new Databaseconnection();
        PreparedStatement prepStat;
        //create an arraylist to hold the result set
        ArrayList<retrieveLoan> retrievedloan = new ArrayList<>();
        //create String query
        String query = "Select * from loan_charges  where  member_id = ? and chama_id = ? and loan_status = ? ";
        prepStat = connection.connect().prepareStatement(query);
        //prepStat.setString(1, loan.getLoanStatus());
        prepStat.setInt(1, loan.getMemberidNumber());
        prepStat.setInt(2, loan.getChamaID());
        prepStat.setString(3, loan.getLoanStatus());
        ResultSet set = prepStat.executeQuery();
        while (set.next()) {
            retrieveLoan loanRepay = new retrieveLoan();
            loanRepay.setFirstName(set.getString("first_name"));

            loanRepay.setSecondName(set.getString("second_name"));
            loanRepay.setLoanid(set.getInt("loan_id"));
            loanRepay.setMemberidNumber(set.getInt("member_id"));
            loanRepay.setDateRepaid(set.getDate("date_repaid").toString());
            loanRepay.setLoanedamount(set.getInt("repaid_amount"));

            retrievedloan.add(loanRepay);

        }
        return retrievedloan;

    }
    //retrieve 

    public static ArrayList<retrieveLoan> getRepayDate(int chamaID, int memberID) throws SQLException {

        // arraylist to retrieve
        ArrayList<retrieveLoan> loanAdd = new ArrayList<>();
        Databaseconnection connection = new Databaseconnection();
        //create prepared statements
        PreparedStatement prepStat;
        //create query
        String query = "select * from loan_table where chama_id = ? and  member_id = ? ";
        prepStat = connection.connect().prepareStatement(query);

        prepStat.setInt(1, chamaID);
        prepStat.setInt(2, memberID);

        ResultSet set = prepStat.executeQuery();

        retrieveLoan loandates;

        while (set.next()) {
            loandates = new retrieveLoan();
            loandates.setDateCreated(set.getDate("date_created").toString());
            loandates.setDateRepaid(set.getString("repay_date"));
            loandates.setChamaID(set.getInt("chama_id"));

            loanAdd.add(loandates);

        }
        return loanAdd;
    }

    public static int payLoan(int amount, int profit, int lid, String status) throws SQLException {
        Databaseconnection connection = new Databaseconnection();
        PreparedStatement prepStat;
        String query = "update  loan_charges  set repaid_amount = ? , loans_profit = ?,loan_status = ? where loan_id = ?";
        prepStat = connection.connect().prepareStatement(query);
        prepStat.setInt(1, amount);
        prepStat.setInt(2, profit);
        prepStat.setString(3, status);
        prepStat.setInt(4, lid);

        return prepStat.executeUpdate();
    }
//clear the loan from database

    public static int clearRepaidLoan(retrieveLoan loan) throws SQLException {

        Databaseconnection connection = new Databaseconnection();
        PreparedStatement prepStat;
        String query = "delete from loan_table where loan_id = ?";
        prepStat = connection.connect().prepareStatement(query);
        prepStat.setInt(1, loan.getLoanid());

        return prepStat.executeUpdate();
    }

//select chama contribution between dates
    public static ArrayList<MemberContribution> getChamaContribution(String startDate, String endDate, int chamaID) throws SQLException {
        ArrayList<MemberContribution> memberC = new ArrayList<>();
        Databaseconnection connection = new Databaseconnection();
        PreparedStatement prepStat;
        ResultSet rs;
        String query = "select m.first_name as 'member_fname',m.member_id as 'memberuniqueacc',m.second_name as 'member_sname', "
                + "c.amount  as 'contr_amount',c.date_contrib as 'date_contrib' from chama_contribution  as c inner join chama_member   as m on m.member_national = c.member_id  "
                + " where  c.chama_id = ? and  c.date_contrib between ? and ? group by m.first_name, m.member_id, m.second_name, c.amount, c.date_contrib  ";

        prepStat = connection.connect().prepareStatement(query);
        prepStat.setInt(1, chamaID);
        prepStat.setString(2, startDate);
        prepStat.setString(3, endDate);

        rs = prepStat.executeQuery();
        MemberContribution memberContrib;
        while (rs.next()) {
            memberContrib = new MemberContribution();
            memberContrib.setFname(rs.getString("member_fname"));
            memberContrib.setLname(rs.getString("member_sname"));
            memberContrib.setAmount(rs.getInt("contr_amount"));
            memberContrib.setDateContributed(rs.getDate("date_contrib").toString());
            memberC.add(memberContrib);
        }
        return memberC;
    }

    public static String EmailExist(UserClass user) throws SQLException {

        Databaseconnection connection = new Databaseconnection();
        //create prepared statements
        PreparedStatement prepStat;

        String query = "Select user_email from chama_user where user_email=?";

        prepStat = connection.connect().prepareStatement(query);
        prepStat.setString(1, user.getEmailaddress());

        ResultSet set = prepStat.executeQuery();
        String email;
        while (set.next()) {
            email = set.getString("user_email");
            if (email.equals(user.getEmailaddress())) {

                return "true";

            }

        }
        return "false";

    }
    public static ArrayList<retrieveLoan> repaidLoans(retrieveLoan loan,String sDate,String eDate) throws SQLException {

        Databaseconnection connection = new Databaseconnection();
        PreparedStatement prepStat;
        //create an arraylist to hold the result set
        ArrayList<retrieveLoan> retrievedloan = new ArrayList<>();
        //create String query
        String query = "Select * from loan_charges  where  chama_id = ? and loan_status = ?  and date_repaid between ? and ? ";
        prepStat = connection.connect().prepareStatement(query);
        //prepStat.setString(1, loan.getLoanStatus()
        prepStat.setInt(1, loan.getChamaID());
        prepStat.setString(2, loan.getLoanStatus());
        prepStat.setString(3, sDate);
        prepStat.setString(4, eDate);
        ResultSet set = prepStat.executeQuery();
        while (set.next()) {
            retrieveLoan loanRepay = new retrieveLoan();
            loanRepay.setFirstName(set.getString("first_name"));
            loanRepay.setSecondName(set.getString("second_name"));
            loanRepay.setLoanid(set.getInt("loan_id"));
            loanRepay.setMemberidNumber(set.getInt("member_id"));
            loanRepay.setDateRepaid(set.getDate("date_repaid").toString());
            loanRepay.setLoanedamount(set.getInt("repaid_amount"));
            loanRepay.setLoan_profits(set.getInt("loans_profit"));

            retrievedloan.add(loanRepay);

        }
        return retrievedloan;

    }
    
    public static String TreasurerExist(int chamaID) throws SQLException {

        Databaseconnection connection = new Databaseconnection();
        //create prepared statements
        PreparedStatement prepStat;

        String query = "Select * from my_chama where admin_id = ? ";

        prepStat = connection.connect().prepareStatement(query);
        prepStat.setInt(1,chamaID);

        ResultSet set = prepStat.executeQuery();
      
        while (set.next()) {
                return "true";

            }

        
        return "false";

    }
    public static int changePassword(int userID,String pass) throws SQLException{
         Databaseconnection connection = new Databaseconnection();
        //create prepared statements
        PreparedStatement prepStat;
        String query = "update  chama_user  set user_password = ?  where user_id = ?";
        prepStat = connection.connect().prepareStatement(query);
        prepStat.setString(1, pass);
        prepStat.setInt(2, userID);
   return prepStat.executeUpdate();
    }
    
    public static int getUserID(String email) throws SQLException{
    Databaseconnection connection = new Databaseconnection();
        //create prepared statements
        PreparedStatement prepStat;
        String query = "select user_id from chama_user where user_email = ?";
        prepStat = connection.connect().prepareStatement(query);
        prepStat.setString(1, email);
        ResultSet set = prepStat.executeQuery();
        int id = 0;
        while(set.next()){
        id = set.getInt("user_id");
        
        
        }
        return id;
    
    
    
    }
    //set default interests into the system
    public static void createCharges(int penInterest,int loancharge,int chamaID) throws SQLException{
        
    Databaseconnection connection = new Databaseconnection();
        //create prepared statements
        PreparedStatement prepStat;
        String query = "insert into chama_interests(chama_id,loan_inter,pen_charges) values(?,?,?)";
        prepStat = connection.connect().prepareStatement(query);
        prepStat.setInt(1, chamaID);
        prepStat.setInt(2, loancharge);
        prepStat.setInt(3, penInterest);
        
        prepStat.execute();
 
    
    }
    public static int updateCharges(String col,int amount,int chamaID) throws SQLException{
        
    Databaseconnection connection = new Databaseconnection();
        //create prepared statements
        PreparedStatement prepStat;
        String query = "update chama_interests set "+col+" = ?  where chama_id = ?";
        prepStat = connection.connect().prepareStatement(query);
        prepStat.setInt(1, amount);
        prepStat.setInt(2, chamaID);
  
      return prepStat.executeUpdate();
    
    }
    public static int getCharges(String col,int chamaID) throws SQLException{
        Databaseconnection connection = new Databaseconnection();
        //create prepared statements
        PreparedStatement prepStat;
        String query = "select  "+col+" from chama_interests  where chama_id = ?";
     prepStat = connection.connect().prepareStatement(query);
        
        prepStat.setInt(1, chamaID);
        
       ResultSet rs = prepStat.executeQuery();
       int charge = 0;
        while (rs.next()) {            
            charge = rs.getInt(col);
        }
    return  charge;
    }
    
   
}
