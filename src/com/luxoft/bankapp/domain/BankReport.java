package com.luxoft.bankapp.domain;

import java.util.*;
import java.util.stream.Collectors;

public class BankReport {
    public int getNumberOfClients(Bank bank) {
        return bank.getClients().size();
    }

    public int getNumberOfAccounts(Bank bank) {
        return bank.getClients().stream().map(Client::getAccounts).mapToInt(Collection::size).sum();
    }

    public SortedSet<Client> getClientsSorted(Bank bank) {
        return new TreeSet<>(bank.getClients());
    }

    public double getTotalSumInAccounts(Bank bank) {
        return bank.getClients().stream().map(Client::getAccounts)
                .flatMap(Collection::stream).mapToDouble(Account::getBalance).sum();

    }

    public SortedSet<Account> getAccountsSortedBySum(Bank bank) {
        SortedSet<Account> treeSet = new TreeSet<>(Comparator.comparingDouble(Account::getBalance));
        treeSet.addAll(bank.getClients().stream().map(Client::getAccounts)
                .flatMap(Collection::stream).toList());
        return treeSet;
    }

    public double getBankCreditSum(Bank bank) {
        return bank.getClients().stream().map(Client::getAccounts)
                .flatMap(Collection::stream).filter(CheckingAccount.class::isInstance)
                .map(CheckingAccount.class::cast).mapToDouble(CheckingAccount::getOverdraft).sum();

    }

    public Map<Client, Collection<Account>> getCustomerAccounts(Bank bank) {
        return bank.getClients()
                .stream().collect(Collectors.toMap(client -> client, Client::getAccounts));

    }

    public Map<String, List<Client>> getClientsByCity(Bank bank) {
        return bank.getClients().stream().collect(Collectors.groupingBy(Client::getCity));

    }
}
