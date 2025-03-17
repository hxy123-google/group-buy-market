package org.example.api;


import org.example.api.dto.LockMarketPayOrderRequestDTO;
import org.example.api.dto.LockMarketPayOrderResponseDTO;
import org.example.api.response.Response;

/**
 * @author Fuzhengwei bugstack.cn @小傅哥
 * @description 营销交易服务接口
 * @create 2025-01-11 13:49
 */
public interface IMarketTradeService {

    Response<LockMarketPayOrderResponseDTO> lockMarketPayOrder(LockMarketPayOrderRequestDTO lockMarketPayOrderRequestDTO);

}
