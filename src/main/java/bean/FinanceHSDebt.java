package bean;

import lombok.Data;

import java.io.Serializable;

@Data
public class FinanceHSDebt implements Serializable {

   //股票代码
    private String code ;

   //股票名称
    private String name ;

   //报告类型
    private int mtype ;

   //报告日期
    private String tdate ;

   //现金及存放中央银行款项
    private float cash_deposit_pbc ;

   //现金及存放中央银行款项（同比）
    private float cash_deposit_pbc_yoy ;

   //存放同业款项
    private float deposit_interbank ;

   //存放同业款项（同比）
    private float deposit_interbank_yoy ;

   //贵金属
    private float precious_metal ;

   //贵金属（同比）
    private float precious_metal_yoy ;

   //拆出资金
    private float lend_fund ;

   //拆出资金（同比）
    private float lend_fund_yoy ;

   //以公允价值计量且其变动计入当期损益的金融资产
    private float fvtpl_finasset ;

   //以公允价值计量且其变动计入当期损益的金融资产（同比）
    private float fvtpl_finasset_yoy ;

   //交易性金融资产 其中:交易性金融资产
    private float trade_finasset ;

   //交易性金融资产 其中:交易性金融资产（同比）
    private float trade_finasset_yoy ;

   //指定以公允价值计量且其变动计入当期损益的金融资产 其中:指定以公允价值计量且其变动计入当期损益的金融资产
    private float appoint_fvtpl_finasset ;

   //指定以公允价值计量且其变动计入当期损益的金融资产 其中:指定以公允价值计量且其变动计入当期损益的金融资产（同比）
    private float appoint_fvtpl_finasset_yoy ;

   //衍生金融资产
    private float derive_finasset ;

   //衍生金融资产（同比）
    private float derive_finasset_yoy ;

   //买入返售金融资产
    private float buy_resale_finasset ;

   //买入返售金融资产（同比）
    private float buy_resale_finasset_yoy ;

   //应收账款
    private float accounts_rece ;

   //应收账款（同比）
    private float accounts_rece_yoy ;

   //应收利息
    private float interest_rece ;

   //应收利息（同比）
    private float interest_rece_yoy ;

   //发放贷款及垫款
    private float loan_advance ;

   //发放贷款及垫款（同比）
    private float loan_advance_yoy ;

   //交易性金融资产
    private float trade_finasset_notfvtpl ;

   //交易性金融资产（同比）
    private float trade_finasset_notfvtpl_yoy ;

   //债权投资
    private float creditor_invest ;

   //债权投资（同比）
    private float creditor_invest_yoy ;

   //其他债权投资
    private float other_creditor_invest ;

   //其他债权投资（同比）
    private float other_creditor_invest_yoy ;

   //其他权益工具投资
    private float other_equity_invest ;

   //其他权益工具投资（同比）
    private float other_equity_invest_yoy ;

   //可供出售金融资产
    private float available_sale_finasset ;

   //可供出售金融资产（同比）
    private float available_sale_finasset_yoy ;

   //持有至到期投资
    private float hold_maturity_invest ;

   //持有至到期投资（同比）
    private float hold_maturity_invest_yoy ;

   //应收款项类投资
    private float invest_rece ;

   //应收款项类投资（同比）
    private float invest_rece_yoy ;

   //以摊余成本计量的金融资产
    private float amortize_cost_finasset ;

   //以摊余成本计量的金融资产（同比）
    private float amortize_cost_finasset_yoy ;

   //以公允价值计量且其变动计入其他综合收益的金融资产
    private float fvtoci_finasset ;

   //以公允价值计量且其变动计入其他综合收益的金融资产（同比）
    private float fvtoci_finasset_yoy ;

   //持有待售资产
    private float holdsale_asset ;

   //持有待售资产（同比）
    private float holdsale_asset_yoy ;

   //长期股权投资
    private float long_equity_invest ;

   //长期股权投资（同比）
    private float long_equity_invest_yoy ;

   //对子公司的投资
    private float invest_subsidiary ;

   //对子公司的投资（同比）
    private float invest_subsidiary_yoy ;

   //对联营和合营企业的投资
    private float invest_joint ;

   //对联营和合营企业的投资（同比）
    private float invest_joint_yoy ;

   //投资性房地产
    private float invest_realestate ;

   //投资性房地产（同比）
    private float invest_realestate_yoy ;

   //固定资产
    private float fixed_asset ;

   //固定资产（同比）
    private float fixed_asset_yoy ;

   //在建工程
    private float cip ;

   //在建工程（同比）
    private float cip_yoy ;

   //使用权资产
    private float useright_asset ;

   //使用权资产（同比）
    private float useright_asset_yoy ;

   //无形资产
    private float intangible_asset ;

   //无形资产（同比）
    private float intangible_asset_yoy ;

   //商誉
    private float goodwill ;

   //商誉（同比）
    private float goodwill_yoy ;

   //待处理抵债资产
    private float pend_mortgage_asset ;

   //待处理抵债资产（同比）
    private float pend_mortgage_asset_yoy ;

   //减:抵债资产减值准备
    private float mortgage_asset_impairment ;

   //减:抵债资产减值准备（同比）
    private float mortgage_asset_impairment_yoy ;

   //待处理抵债资产净额
    private float net_pendmortgage_asset ;

   //待处理抵债资产净额（同比）
    private float net_pendmortgage_asset_yoy ;

   //递延所得税资产
    private float defer_tax_asset ;

   //递延所得税资产（同比）
    private float defer_tax_asset_yoy ;

   //长期待摊费用
    private float long_prepaid_expense ;

   //长期待摊费用（同比）
    private float long_prepaid_expense_yoy ;

   //其他资产
    private float other_asset ;

   //其他资产（同比）
    private float other_asset_yoy ;

   //资产其他项目
    private float asset_other ;

   //资产其他项目（同比）
    private float asset_other_yoy ;

   //资产平衡项目
    private float asset_balance ;

   //资产平衡项目（同比）
    private float asset_balance_yoy ;

   //资产总计
    private float total_assets ;

   //资产总计（同比）
    private float total_assets_yoy ;

   //向中央银行借款
    private float loan_pbc ;

   //向中央银行借款（同比）
    private float loan_pbc_yoy ;

   //同业及其他金融机构存放款项
    private float iofi_deposit ;

   //同业及其他金融机构存放款项（同比）
    private float iofi_deposit_yoy ;

   //拆入资金
    private float borrow_fund ;

   //拆入资金（同比）
    private float borrow_fund_yoy ;

   //交易性金融负债
    private float trade_finliab_notfvtpl ;

   //交易性金融负债（同比）
    private float trade_finliab_notfvtpl_yoy ;

   //以公允价值计量且其变动计入当期损益的金融负债
    private float fvtpl_finliab ;

   //以公允价值计量且其变动计入当期损益的金融负债（同比）
    private float fvtpl_finliab_yoy ;

   //交易性金融负债 其中:交易性金融负债
    private float trade_finliab ;

   //交易性金融负债 其中:交易性金融负债（同比）
    private float trade_finliab_yoy ;

   //指定以公允价值计量且其变动计入当期损益的金融负债 其中:指定以公允价值计量且其变动计入当期损益的金融负债
    private float appoint_fvtpl_finliab ;

   //指定以公允价值计量且其变动计入当期损益的金融负债 其中:指定以公允价值计量且其变动计入当期损益的金融负债（同比）
    private float appoint_fvtpl_finliab_yoy ;

}

