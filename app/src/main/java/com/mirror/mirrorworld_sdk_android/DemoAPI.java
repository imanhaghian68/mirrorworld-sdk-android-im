package com.mirror.mirrorworld_sdk_android;

public enum DemoAPI {
    //Client
    INIT_SDK,
    GET_ENVIRONMENT,
    LOGIN_With_EMAIL,
    START_LOGIN,
    IS_LOGGED,
    OPEN_WALLET,
    OPEN_MARKET,
    SET_JWT,
    LOGOUT,
    GUEST_LOGIN,
    FETCH_USER,
    QUERY_USER,

    //Asset/Mint
    CREATE_VERIFIED_COLLECTION,
    MINT_NFT,
    UPDATE_NFT,
    LIST_NFT,
    UPDATE_NFT_LISTING,
    CANCEL_NFT_LISTING,

    //Confirmation
    CHECK_STATUS_OFMINTING,
    CHECK_STATUS_TRANSACTION,


    FETCH_NFT_BY_CREATOR,
    FETCH_NFT_BY_OWNER_ADDRESSES,
    FETCH_NFT_BY_MINT_ADDRESSES,
    FETCH_NFT_BY_UPDATE_AUTHORITIES,
    FETCH_SINGLE_NFT_DETAILS,
    FETCH_NFT_MARKETPLACE_ACTIVITY,
    TRANSFER_NFT_TO_ANOTHER_WALLET,
    BUY_NFT,

    //wallet
    GET_WALLET_TOKEN,
    GET_TOKENS_BY_WALLET,
    WALLET_TRANSACTIONS,
    WALLET_TRANSACTIONS_BY_WALLET,
    WALLET_TRANSACTIONS_BY_SIGNATURE,
    TRANSFER_SOL,
    TRANSFER_SPL_TOKEN,
    WALLET_TRANSFER_ETH,
    WALLET_GET_TRANSACTION_OF_TRANSFER_SOL,
    WALLET_GET_TRANSACTION_OF_TRANSFER_TOKEN,

    //Metadata
    GET_COLLECTION_FILTER_INFO,
    GET_COLLECTION_INFO,
    METADATA_GET_COLLECTION_SUMMARY,
    SEARCH_NFTS,
    GET_NFT_INFO_SOLANA,
    WALLET_NFT_INFO_MULCHAIN,
    RECOMMEND_SEARCH_NFT,
    GET_NFTS_SOLANA,
    GET_NFTS_MULCHAIN,
    GET_NFT_REAL_PRICE,
    GET_NFT_EVENTS_SOLANA,
    GET_NFT_EVENTS_MULCHAIN,
}
