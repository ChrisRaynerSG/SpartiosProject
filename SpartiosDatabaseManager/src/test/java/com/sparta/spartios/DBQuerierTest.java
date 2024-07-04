package com.sparta.spartios;

import com.sparta.spartios.Dao.DBQuerier;
import com.sparta.spartios.datasanitisation.DataCheck;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DBQuerierTest {

    @Test
    void testtest(){
        DBQuerier db = new DBQuerier();
        db.queryDB();
    }
}
