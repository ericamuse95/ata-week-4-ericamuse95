package compare;

import com.kenzie.groupactivity.bigspender.types.Customer;
import com.kenzie.groupactivity.bigspender.types.CustomerTotalSpend;
import com.kenzie.groupactivity.bigspender.types.ServiceSpend;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;

public class CustomerTotalSpendBySpend implements Comparator<CustomerTotalSpend> {

    @Override
    public int compare (CustomerTotalSpend o1, CustomerTotalSpend o2) {
       return Long.compare(o1.getTotalSpend(), o2.getTotalSpend());
    }

}




