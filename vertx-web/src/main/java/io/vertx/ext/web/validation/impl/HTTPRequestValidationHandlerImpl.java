package io.vertx.ext.web.validation.impl;

import io.vertx.ext.web.validation.*;

/**
 * @author Francesco Guardiani @slinkydeveloper
 */
public class HTTPRequestValidationHandlerImpl extends BaseValidationHandler implements HTTPRequestValidationHandler {

  public HTTPRequestValidationHandlerImpl() {
    super();
  }

  @Override
  public HTTPRequestValidationHandler addPathParam(String parameterName, ParameterType type) {
    this.addPathParamRule(ParameterValidationRuleImpl.ParameterValidationRuleFactory.createValidationRule(parameterName, type, false, false, ParameterLocation.PATH));
    return this;
  }

  @Override
  public HTTPRequestValidationHandler addPathParamWithPattern(String parameterName, String pattern) {
    this.addPathParamRule(ParameterValidationRuleImpl.ParameterValidationRuleFactory.createValidationRuleWithCustomTypeValidator(parameterName, ParameterTypeValidator.createStringTypeValidator(pattern), false, false, ParameterLocation.PATH));
    return this;
  }

  @Override
  public HTTPRequestValidationHandler addPathParamWithCustomTypeValidator(String parameterName, ParameterTypeValidator validator, boolean allowEmptyValue) {
    this.addPathParamRule(ParameterValidationRuleImpl.ParameterValidationRuleFactory.createValidationRuleWithCustomTypeValidator(parameterName, validator, false, allowEmptyValue, ParameterLocation.PATH));
    return this;
  }

  @Override
  public HTTPRequestValidationHandler addQueryParam(String parameterName, ParameterType type, boolean required) {
    this.addQueryParamRule(ParameterValidationRuleImpl.ParameterValidationRuleFactory.createValidationRule(parameterName, type, !required, false, ParameterLocation.QUERY));
    return this;
  }

  @Override
  public HTTPRequestValidationHandler addQueryParamWithPattern(String parameterName, String pattern, boolean required) {
    this.addQueryParamRule(ParameterValidationRuleImpl.ParameterValidationRuleFactory.createValidationRuleWithCustomTypeValidator(parameterName, ParameterTypeValidator.createStringTypeValidator(pattern), !required, false, ParameterLocation.QUERY));
    return this;
  }

  @Override
  public HTTPRequestValidationHandler addQueryParamsArray(String arrayName, ParameterType type, boolean required) {
    this.addQueryParamRule(ParameterValidationRuleImpl.ParameterValidationRuleFactory.createValidationRuleWithCustomTypeValidator(arrayName, ParameterTypeValidator.createArrayTypeValidator(type.getValidationMethod()), !required, false, ParameterLocation.QUERY));
    return this;
  }

  @Override
  public HTTPRequestValidationHandler addQueryParamsArrayWithPattern(String arrayName, String pattern, boolean required) {
    this.addQueryParamRule(ParameterValidationRuleImpl.ParameterValidationRuleFactory.createValidationRuleWithCustomTypeValidator(arrayName, ParameterTypeValidator.createArrayTypeValidator(ParameterTypeValidator.createStringTypeValidator(pattern)), !required, false, ParameterLocation.QUERY));
    return this;
  }

  @Override
  public HTTPRequestValidationHandler addQueryParamWithCustomTypeValidator(String parameterName, ParameterTypeValidator validator, boolean required, boolean allowEmptyValue) {
    this.addQueryParamRule(ParameterValidationRuleImpl.ParameterValidationRuleFactory.createValidationRuleWithCustomTypeValidator(parameterName, validator, !required, allowEmptyValue, ParameterLocation.QUERY));
    return this;
  }

  @Override
  public HTTPRequestValidationHandler addHeaderParam(String headerName, ParameterType type, boolean required) {
    this.addHeaderParamRule(ParameterValidationRuleImpl.ParameterValidationRuleFactory.createValidationRule(headerName, type, !required, false, ParameterLocation.HEADER));
    return this;
  }

  @Override
  public HTTPRequestValidationHandler addHeaderParamWithPattern(String headerName, String pattern, boolean required) {
    this.addHeaderParamRule(ParameterValidationRuleImpl.ParameterValidationRuleFactory.createValidationRuleWithCustomTypeValidator(headerName, ParameterTypeValidator.createStringTypeValidator(pattern), !required, false, ParameterLocation.HEADER));
    return this;
  }

  @Override
  public HTTPRequestValidationHandler addHeaderParamWithCustomTypeValidator(String headerName, ParameterTypeValidator validator, boolean required, boolean allowEmptyValue) {
    this.addHeaderParamRule(ParameterValidationRuleImpl.ParameterValidationRuleFactory.createValidationRuleWithCustomTypeValidator(headerName, validator, !required, allowEmptyValue, ParameterLocation.HEADER));
    return this;
  }

  @Override
  public HTTPRequestValidationHandler addFormParam(String parameterName, ParameterType type, boolean required) {
    this.addFormParamRule(ParameterValidationRuleImpl.ParameterValidationRuleFactory.createValidationRule(parameterName, type, !required, false, ParameterLocation.BODY_FORM));
    return this;
  }

  @Override
  public HTTPRequestValidationHandler addFormParamWithPattern(String parameterName, String pattern, boolean required) {
    this.addFormParamRule(ParameterValidationRuleImpl.ParameterValidationRuleFactory.createValidationRuleWithCustomTypeValidator(parameterName, ParameterTypeValidator.createStringTypeValidator(pattern), !required, false, ParameterLocation.BODY_FORM));
    return this;
  }

  @Override
  public HTTPRequestValidationHandler addFormParamsArray(String parameterName, ParameterType type, boolean required) {
    this.addFormParamRule(ParameterValidationRuleImpl.ParameterValidationRuleFactory.createValidationRuleWithCustomTypeValidator(parameterName, ParameterTypeValidator.createArrayTypeValidator(type.getValidationMethod()), !required, false, ParameterLocation.BODY_FORM));
    return this;
  }

  @Override
  public HTTPRequestValidationHandler addFormParamsArrayWithPattern(String parameterName, String pattern, boolean required) {
    this.addFormParamRule(ParameterValidationRuleImpl.ParameterValidationRuleFactory.createValidationRuleWithCustomTypeValidator(parameterName, ParameterTypeValidator.createArrayTypeValidator(ParameterTypeValidator.createStringTypeValidator(pattern)), !required, false, ParameterLocation.BODY_FORM));
    return this;
  }

  @Override
  public HTTPRequestValidationHandler addFormParamWithCustomTypeValidator(String parameterName, ParameterTypeValidator validator, boolean required, boolean allowEmptyValue) {
    this.addFormParamRule(ParameterValidationRuleImpl.ParameterValidationRuleFactory.createValidationRuleWithCustomTypeValidator(parameterName, validator, !required, allowEmptyValue, ParameterLocation.BODY_FORM));
    return this;
  }

  @Override
  public HTTPRequestValidationHandler addCustomValidatorFunction(CustomValidator customValidator) {
    this.addCustomValidator(customValidator);
    return this;
  }

  @Override
  public HTTPRequestValidationHandler addJsonBodySchema(String jsonSchema) {
    this.setEntireBodyValidator(JsonTypeValidator.JsonTypeValidatorFactory.createJsonTypeValidator(jsonSchema));
    return this;
  }

  @Override
  public HTTPRequestValidationHandler addXMLBodySchema(String xmlSchema) {
    this.setEntireBodyValidator(XMLTypeValidator.XMLTypeValidatorFactory.createXMLTypeValidator(xmlSchema));
    return this;
  }

  @Override
  public HTTPRequestValidationHandler addRequiredFile(String filename) {
    this.addFileUploadName(filename);
    return this;
  }
}
