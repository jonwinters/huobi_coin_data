package pub.terminal.coin.tradeinfo.model;


import lombok.Builder;
import lombok.Data;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import java.util.List;

@Entity
@Data
@Table(name = "trade_detail")
@Builder
public class TradeDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long sId;

    private Long timeStamp;

    public enum Type {
        ETH, BTC
    }

    private Type type;

    @ElementCollection
    @CollectionTable(
            name = "trade_data",
            joinColumns = @JoinColumn(name = "trade_detail_id")
    )
    private List<TradeData> datas;

}
