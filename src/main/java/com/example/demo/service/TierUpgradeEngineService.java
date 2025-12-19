import com.example.demo.entity.TierHistoryRecord;
import java.util.List;

public interface TierUpgradeEngineService {

    TierHistoryRecord evaluateAndUpgradeTier(Long customerId);

    List<TierHistoryRecord> getAllHistory();

    List<TierHistoryRecord> getHistoryByCustomer(Long customerId); // ✅ ADD THIS
}
