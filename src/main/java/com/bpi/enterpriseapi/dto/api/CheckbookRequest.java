package com.bpi.enterpriseapi.dto.api;

import java.math.BigDecimal;
import java.util.Date;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import com.bpi.enterpriseapi.constraints.AcceptedLength;
import com.bpi.enterpriseapi.constraints.AcceptedStringValue;
import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel
@Data
public class CheckbookRequest {

	@NotBlank
	@Length(min = 20, max = 20)
	@Pattern(regexp = "^[0-9]+$")
	@ApiModelProperty(value = "Confirmation number of customer", example = "01234567890123456789", required = true)
	private String confirmationNumber;

	@NotBlank
	@Length(min = 2, max = 2)
	@Pattern(regexp = "[A-Z0-9]*")
	@AcceptedStringValue(value = { "FC" })
	@ApiModelProperty(value = "Transaction type", example = "FC", required = true)
	private String transactionType;

	@NotNull
	@ApiModelProperty(value = "Transaction date", example = "2019-03-21T15:40:10+0800", required = true)
	private Date transactionDate;

	@NotBlank
	@Pattern(regexp = "^[0-9A-Za-z]+$")
	@Length(max = 12)
	@ApiModelProperty(value = "User ID of customer", example = "EOLNG001", required = true)
	private String userId;

	@NotBlank
	@Length(min = 14, max = 14)
	@Pattern(regexp = "^[0-9]+$")
	@JsonProperty("customerNumber")
	@ApiModelProperty(value = "RM number of customer", example = "00000000000001", required = true)
	private String rmNumber;

	@NotBlank
	@AcceptedLength(value = { 10, 14 })
	@Pattern(regexp = "^[0-9]+$")
	@ApiModelProperty(value = "Bank account number of customer", example = "00000010000001", required = true)
	private String sourceAccountNumber;

	@NotNull
	@Min(value = 1)
	@ApiModelProperty(value = "Number of checkbooks ordered", example = "3", required = true)
	private Integer numberOfChecks;

	@NotNull
	@Digits(integer = 13, fraction = 2)
	@ApiModelProperty(value = "The amount that needs to be paid", example = "50", required = true)
	private BigDecimal fee;

	@NotBlank
	@Length(max = 2)
	@Pattern(regexp = "^[0-9]+$")
	@ApiModelProperty(value = "Institution code of the bank", example = "02", required = true)
	private String institutionCode;

	@NotBlank
	@Length(max = 3)
	@Pattern(regexp = "^[0-9]+$")
	@ApiModelProperty(value = "Branch code of the bank", example = "084", required = true)
	private String branchCode;

	@NotBlank
	@Length(max = 3)
	@Pattern(regexp = "^[0-9]+$")
	@ApiModelProperty(value = "Currency used in the transaction", example = "001", required = true)
	private String currencyCode;
}
