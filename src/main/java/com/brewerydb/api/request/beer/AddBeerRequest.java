package com.brewerydb.api.request.beer;

import com.brewerydb.api.exception.MissingRequestParameterException;
import com.brewerydb.api.request.AbstractRequest;
import com.brewerydb.api.request.AbstractRequestBuilder;

import java.util.List;
import java.util.Map;

public class AddBeerRequest extends AbstractRequest {

    AddBeerRequest(Map<String, String> params) {
        super(params);
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder extends AbstractRequestBuilder<AddBeerRequest> {

        private Builder() {}

        public Builder withName(String name) {
            params.put("name", name);
            return this;
        }

        public Builder withStyleId(Integer id) {
            params.put("styleId", id.toString());
            return this;
        }

        public Builder withDescription(String description) {
            params.put("description", description);
            return this;
        }

        public Builder withAbv(String abv) {
            params.put("abv", abv);
            return this;
        }

        public Builder withIbu(String ibu) {
            params.put("ibu", ibu);
            return this;
        }

        public Builder withGlasswareId(Integer glasswareId) {
            params.put("glasswareId", glasswareId.toString());
            return this;
        }

        public Builder withSrmId(Integer srmId) {
            params.put("srmId", srmId.toString());
            return this;
        }

        public Builder withAvailableId(Integer availableId) {
            params.put("availableId", availableId.toString());
            return this;
        }

        public Builder isOrganic(boolean isOrganic) {
            params.put("isOrganic", isOrganic ? "Y" : "N");
            return this;
        }

        public Builder withBeerVariationId(String beerVariationId) {
            params.put("beerVariationId", beerVariationId);
            return this;
        }

        public Builder withYear(String year) {
            params.put("year", year);
            return this;
        }

        public Builder withFoodPairings(String foodPairings) {
            params.put("foodPairings", foodPairings);
            return this;
        }

        public Builder withServingTemperature(String servingTemperature) {
            params.put("servingTemperature", servingTemperature);
            return this;
        }

        public Builder withOriginalGravity(String originalGravity) {
            params.put("originalGravity", originalGravity);
            return this;
        }

        public Builder withBreweries(List<String> breweries) {
            String breweriesString = breweries.toString();
            params.put("brewery", breweriesString.substring(1, breweriesString.length() - 1).replaceAll(", ", ","));
            return this;
        }

        public Builder withLabel(String label) {
            params.put("label", label);
            return this;
        }

        public AddBeerRequest build() {
            if (params.get("name") == null) {
                throw new MissingRequestParameterException("name");
            }

            if (params.get("styleId") == null) {
                throw new MissingRequestParameterException("styleId");
            }

            return new AddBeerRequest(params);
        }
    }
}
