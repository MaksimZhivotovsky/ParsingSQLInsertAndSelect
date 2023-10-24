package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.statement.insert.Insert;

@SpringBootApplication
public class ParsingSQLInsertAndSelectApplication {

    public static void main(String[] args) {
        SpringApplication.run(ParsingSQLInsertAndSelectApplication.class, args);

        String SQL = "INSERT INTO public.monitoring_object_property "+
                "(name, value, dic_property_type_id, description, entity_id, dic_parameter_id, property_map_id, is_map, dic_type_id, "+
                "entity_map_id, is_require, dic_value_id, is_measured, measure_unit_id, system_name,  default_colour,  is_hide) "+

                "select ?, ?, ?, ?, moe.id as entityId,  dic_parameter_id_case_expretion, null, ? , ? , "+

                " null , ? , ? , ?, ? , null , ? , ?  "+
                "from monitoring_object_entity moe \n" +
                "where   whereClause " +
                " ON CONFLICT (entity_id, name) WHERE is_archive is false DO UPDATE " +
                "  SET value=  'value'  RETURNING id  ;";

        String sql1 = "select t1.name ,t2.address  from t1 ,t2  where t1.id=t2.user_id and t1.name =? and t2.name =?";
// Mysql is used to parsing

        String sqlInsert = "insert into user_default_customization " +
                " (user_id, object_id, customization_id) " +
                " values (p.userId1, objectId1, customizationId1) " +
                " on conflict (user_id, object_id) do update set customization_id = customizationId ";

        String sql = "select is2.name, is2.date_creation, is2.priority_id, rp.rus_name, cp.value, is2.rule_id, " +
                " rs.name, is2.istech, it.name " +
                " from incident_sc is2 " +
                " left join request_priority rp on rp.id = is2.priority_id " +
                " left join colour_palette cp on cp.id = is2.color_id " +
                " left join rule_sc rs on rs.id = is2.rule_id " +
                " left join incident_type it on it.id = is2.incident_type";

//        System.out.println("Program to parse SELECT sql statement");
//        String selectSQL = "Select id, name, location from Database.UserTable " +
//                "where created_dt >= current_date- 180";
//        try {
//            Statement select = (Statement) CCJSqlParserUtil.parse(selectSQL);
//            //Simple Select query parsing
//            System.out.println("Simple single select with where condition\n");
//            System.out.println("List of  columns in select query");
//            System.out.println("--------------------------------");
//            List<SelectItem> selectCols = ((PlainSelect) ((Select) select).getSelectBody()).getSelectItems();
//            for (SelectItem selectItem : selectCols)
//                System.out.println(selectItem.toString());
//
//            System.out.println("Where condition: " + ((PlainSelect) ((Select) select).getSelectBody()).getWhere().toString());
//            SelectUtils.addExpression((Select) select, new Column("newColumnName"));
//            System.out.println("\nModified select with additional column");
//            System.out.println("----------------------------------");
//            System.out.println(select.toString());
//
//            ((Table) ((PlainSelect) ((Select) select).getSelectBody()).getFromItem()).setName("NewSourceTable");
//            ((Table) ((PlainSelect) ((Select) select).getSelectBody()).getFromItem()).setSchemaName("NewSourceSchema");
//            System.out.println("\nModified select with new table and database");
//            System.out.println("-------------------------------------");
//            System.out.println(select.toString());
//            selectSQL = "Select w.id, w.name, w.location from Database.WebLogs w " +
//                    "union Select m.id, m.name, m.location from Database.MobileLogs m ";
//            Statement newSQL = (Statement) CCJSqlParserUtil.parse(selectSQL);
//            List<SelectBody> selectList = ((SetOperationList) ((Select) newSQL).getSelectBody()).getSelects();
//            System.out.println("\nListing all selects from the query");
//            System.out.println("----------------------------------");
//            for (SelectBody selectBody : selectList)
//                System.out.println(selectBody.toString());
//        } catch (JSQLParserException e) {
//            e.printStackTrace();
//        }

        System.out.println("Parsing SQL INSERT statement");
        String insertSQL = "Insert into Database.TargetTable " +
                "select col1, col2, col3 from Database.SourceTable";
        try {
            Insert insertObj = (Insert) CCJSqlParserUtil.parse(SQL); //SQL   sqlInsert
            System.out.println("Original Insert SQL details");
            System.out.println("---------------------------");
            System.out.println("Target Database: " + insertObj.getTable().getSchemaName());
            System.out.println("Target Table: " + insertObj.getTable().getName());

            System.out.println("Select statement of insert: " + insertObj.getColumns());
//            System.out.println("Select statement of insert: " + insertObj.getSelect().toString());




        } catch (JSQLParserException e) {
            throw new RuntimeException(e);
        }






























    }
}
