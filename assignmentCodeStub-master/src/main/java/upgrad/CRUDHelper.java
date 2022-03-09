package upgrad;

import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Accumulators;
import com.mongodb.client.model.Aggregates;
import com.mongodb.client.model.Filters;
import org.bson.Document;
import org.bson.conversions.Bson;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.Arrays;
import java.util.Collections;

import static com.mongodb.client.model.Indexes.descending;
import static com.mongodb.client.model.Projections.excludeId;
import static com.mongodb.client.model.Projections.fields;

public class CRUDHelper {

    /**
     * Display ALl products
     * @param collection
     */
    public static void displayAllProducts(MongoCollection<Document> collection) {
        System.out.println("------ Displaying All Products ------");
        // Call printSingleCommonAttributes to display the attributes on the Screen
        for (Document document : collection.find()) {
            PrintHelper.printSingleCommonAttributes(document);
        }
    }

    /**
     * Display top 5 Mobiles
     * @param collection
     */
    public static void displayTop5Mobiles(MongoCollection<Document> collection) {
        System.out.println("------ Displaying Top 5 Mobiles ------");
        // Call printAllAttributes to display the attributes on the Screen
        Bson filter = Filters.eq("Category", "Mobile");
        for (Document document : collection.find(filter)) {
            PrintHelper.printSingleCommonAttributes(document);
        }
    }

    /**
     * Display products ordered by their categories in Descending order without auto generated Id
     * @param collection
     */
    public static void displayCategoryOrderedProductsDescending(MongoCollection<Document> collection) {
        System.out.println("------ Displaying Products ordered by categories ------");
        // Call printAllAttributes to display the attributes on the Screen
        Bson filter = Filters.in("Category", "Mobile", "Headphone", "Camera");
        for (Document document : collection.find(filter).sort(descending("Category"))) {
            PrintHelper.printSingleCommonAttributes(document);
        }
    }


    /**
     * Display number of products in each group
     * @param collection
     */
    public static void displayProductCountByCategory(MongoCollection<Document> collection) {
        System.out.println("------ Displaying Product Count by categories ------");
        // Call printProductCountInCategory to display the attributes on the Screen
        MongoCursor<Document> cursor = collection.
                aggregate(Collections.
                        singletonList(Aggregates.group("$Category",
                                Accumulators.sum("Count",1)))).cursor();

        while(cursor.hasNext()){
            final Document document = cursor.next();
            PrintHelper.printAllAttributes(document);

        }
    }

    /**
     * Display Wired Headphones
     * @param collection
     */
    public static void displayWiredHeadphones(MongoCollection<Document> collection) {
        System.out.println("------ Displaying Wired headphones ------");
        // Call printAllAttributes to display the attributes on the Screen
        Bson filter = Filters.eq("ConnectorType", "Wired");
        for (Document document : collection.find(filter)) {
            PrintHelper.printAllAttributes(document);
        }

    }

    public static void importDataToMongoDB(Connection connection, String tableName, String category, MongoCollection<Document> collection) throws SQLException {
        Statement statement = connection.createStatement();
        String sql = "select * from " + tableName;
        ResultSet resultSet = statement.executeQuery(sql);
        ResultSetMetaData rsMetaData = resultSet.getMetaData();
        int columnCount = rsMetaData.getColumnCount();

        while (resultSet.next()) {
            Document doc = new Document();
            for (int i = 1; i < columnCount; i++) {
                doc.append(rsMetaData.getColumnName(i), resultSet.getString(rsMetaData.getColumnName(i)));
            }
            doc.append("Category", category);
            collection.insertOne(doc);
        }
        statement.close();
    }
}