package org.example.repos;

import org.example.models.FlashCard;
import org.example.utils.CRUDDaoInterface;
import org.example.utils.ConnectionManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

//public class FlashCardRepo implements CRUDDaoInterface<FlashCard> {
//
//    public Connection conn;
//
//    private static final Logger LOGGER = LoggerFactory.getLogger(FlashCard.class);
//
//    public FlashCardRepo() {
//
//
//
//        try {
//
//            conn = ConnectionManager.getConnection();
//
//            System.out.println(conn.getSchema());
//
//        } catch (SQLException sqlException) {
//            //System.out.println(sqlException.getMessage());
//            LOGGER.error(sqlException.getMessage());
//        }
//    }
//    @Override
//    public int create(FlashCard flashCard) {
//
//        try {
//            String sql = "INSERT INTO flashcards (id,question,answer,creator_id) VALUES (default,?,?,?)";
//            PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
//
//            pstmt.setInt(1, flashCard.setId());
//            pstmt.setString(2, flashCard.setQuestion());
//            pstmt.setString(3, flashCard.setAnswer());
//            pstmt.setString(4, flashCard.setCreatorId());
//
//            //This executes the sql statement above
//            pstmt.executeUpdate();
//
//            //This gives us a result set of the row that was just created
//            ResultSet rs = pstmt.getGeneratedKeys();
//
//            //The cursor is right in front of the first (or only) element in our result set
//            //Calling rs.next() iterates us into the first row
//            rs.next();
//
//            return rs.getInt(1);
//        } catch (SQLException sqlException) {
//            System.out.printf(sqlException.getMessage());
//        }
//
//
//        return 0;
//    }
//
//    @Override
//    public List<FlashCard> getAll() {
//        return null;
//    }
//
//    @Override
//    public FlashCard getById(int id) {
//        return null;
//    }
//
//    @Override
//    public FlashCard update(FlashCard flashCard) {
//        return null;
//    }
//
//    @Override
//    public boolean delete(FlashCard flashCard) {
//        return false;
//    }
//}
