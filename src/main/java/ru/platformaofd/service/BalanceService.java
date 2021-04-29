package ru.platformaofd.service;

import org.springframework.stereotype.Service;
import ru.platformaofd.exception.TechnicalException;
import ru.platformaofd.model.Balance;
import ru.platformaofd.model.enums.ErrorCode;
import ru.platformaofd.repository.BalanceRepository;

import java.util.List;

@Service
public class BalanceService {

    private final BalanceRepository balanceRepository;

    public BalanceService(BalanceRepository balanceRepository) {
        this.balanceRepository = balanceRepository;
    }

    /**
     * Метод сохранения баланса в базу
     * @param balance объект баланса
     * @throws TechnicalException в случае ошибки сохранения
     */
    public void saveBalance(Balance balance) {
        if (balanceRepository.save(balance) == 0) {
            throw new TechnicalException(
                    "Ошибка при добавлении нового баланса",
                    ErrorCode.TECHNICAL.getCode());
        }
    }

    /**
     * Метод получения списка всех балансов пользователя по его id
     * @param userId id пользователя
     * @return список балансов пользователя
     */
    public List<Balance> getAllBalancesByUserId(Long userId) {
        return balanceRepository.getAllBalancesByUserId(userId);
    }
}
