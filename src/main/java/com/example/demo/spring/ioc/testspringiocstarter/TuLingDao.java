package com.example.demo.spring.ioc.testspringiocstarter;

import org.springframework.stereotype.Repository;

/**
 * Created by smlz on 2019/5/19.
 */
@Repository
//@Scope(value = "prototype")
public class TuLingDao {

    private TuLingDataSource tuLingDataSource;

    public TuLingDao(TuLingDataSource tuLingDataSource) {
        this.tuLingDataSource = tuLingDataSource;
        System.out.println("本类的DataSource"+this.tuLingDataSource);
    }

}
