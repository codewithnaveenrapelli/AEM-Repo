(function(document, $) {
    "use strict";
    $(document).on("click", ".cq-dialog-submit", function(e) {

        $(".coral-Form-field[name*='./buttonType']").each(function() {

            const buttontype = $(this).val();
            const parentSiblings = $(this).parent().siblings();
        
            parentSiblings.find(".showhidetargetmulti[data-showhidetargetmultivalue='url']").find(".coral-Form-field[name*='./urlLink']").prop('required', buttontype === 'url');
            parentSiblings.find(".showhidetargetmulti[data-showhidetargetmultivalue='anchor']").find(".coral-Form-field[name*='./anchorName']").prop('required', buttontype === 'anchor');
            parentSiblings.find(".showhidetargetmulti[data-showhidetargetmultivalue='asset']").find(".coral-Form-field[name*='assetLink']").prop('required', buttontype === 'asset');
            parentSiblings.find(".showhidetargetmulti[data-showhidetargetmultivalue='clicktocall']").find(".coral-Form-field[name*='./phoneNumber']").prop('required', buttontype === 'clicktocall');
            parentSiblings.find(".showhidetargetmulti[data-showhidetargetmultivalue='video']").find(".coral-Form-field[name*='./mediaId']").prop('required', buttontype === 'video');
            parentSiblings.find(".showhidetargetmulti[data-showhidetargetmultivalue='video']").find(".coral-Form-field[name*='./playerId']").prop('required', buttontype === 'video');
            parentSiblings.find(".showhidetargetmulti[data-showhidetargetmultivalue='brightCove']").find(".coral-Form-field[name*='./accountID']").prop('required', buttontype === 'brightCove');
            parentSiblings.find(".showhidetargetmulti[data-showhidetargetmultivalue='brightCove']").find(".coral-Form-field[name*='./brightVideoID']").prop('required', buttontype === 'brightCove');
            parentSiblings.find(".showhidetargetmulti[data-showhidetargetmultivalue='brightCove']").find(".coral-Form-field[name*='./brightPlayerID']").prop('required', buttontype === 'brightCove');

        });

    });

    // when dialog gets injected
    $(document).on("foundation-contentloaded", function(e) {
        // if there is already an inital value make sure the according target element becomes visible
        showHideHandler($(".cq-dialog-dropdown-showhide-multi", e.target));
        showHideContHandler($(".cq-dialog-dropdown-height-selection", e.target));
    });

    function showHideContHandler(el) {
        el.each(function(i, element) {
            Coral.commons.ready(element, function(component) {
                showHideCont(component, element);
                component.on("change", function() {
                    showHideCont(component, element);
                });
            });
        })
    }

    $(document).on("selected", ".cq-dialog-dropdown-showhide-multi", function(e) {
        showHideHandler($(this));
    });

    $(document).on("click", "button[coral-multifield-add]", function(e) {
        showHideHandler($(".cq-dialog-dropdown-showhide-multi"));
        showHideContHandler($(".cq-dialog-dropdown-height-selection"));

    });

    function showHideHandler(el) {
        el.each(function(i, element) {
            if ($(element).is("coral-select")) {
                // handle Coral3 base drop-down
                Coral.commons.ready(element, function(component) {
                    showHide(component, element);
                    component.on("change", function() {
                        showHide(component, element);
                    });
                });
            } else {
                // handle Coral2 based drop-down
                let components = $(element).data("select");
                if (components) {
                    showHide(components, element);
                }
            }
        })
    }

    function showHide(component, element) {
        // get the selector to find the target elements. its stored as data-.. attribute
        let target = $(element).data("cq-dialog-dropdown-showhide-target");
        let elementIndex = $(element).closest('coral-multifield-item').index();

        if (target) {
            let value;
            if (component.value) {
                value = component.value;
            } else {
                value = component.getValue();
            }


            $(element).closest('coral-multifield-item').find(target).each(function(index) {
                let tarIndex = $(this).closest('coral-multifield-item').index();
                if (elementIndex == tarIndex) {
                    $(this).not(".hide").addClass("hide");

                    $(this).filter(function() {
                        return $(this).closest('.showhidetargetmulti').data('showhidetargetmultivalue').replace(/ /g, '').split(',').includes(value);
                    }).removeClass("hide");
                }
            });

        }


    }

    function showHideCont(component, element) {
        // get the selector to find the target elements. its stored as data-.. attribute
        let target = $(element).data("cqDialogDropdownShowhideTarget");
        let $target = $(target);

        if (target) {
            let value;

            if (typeof component.value !== "undefined") {
                value = component.value;

            } else if (typeof component.getValue === "function") {
                value = component.getValue();
            }

            if (value === 'm-hbanner--small') {
                $target.each(function() {
                    $(this).not(".hide").addClass("hide");
                    let label = $(this).attr("aria-labelledby").split(" ")[0];
                    let desc = $(this).attr("aria-labelledby").split(" ")[1];
                    let labelEl = document.getElementById(label);
                    let descEl = document.querySelectorAll('[aria-describedby="' + desc + '"]');
                    $(labelEl).not(".hide").addClass("hide");
                    $(descEl).not(".hide").addClass("hide");
                });
            } else {
                $target.each(function() {
                    $(this).removeClass("hide");
                    let label = $(this).attr("aria-labelledby").split(" ")[0];
                    let desc = $(this).attr("aria-labelledby").split(" ")[1];
                    let labelEl = document.getElementById(label);
                    let descEl = document.querySelectorAll('[aria-describedby="' + desc + '"]');
                    $(labelEl).removeClass("hide");
                    $(descEl).removeClass("hide");

                });
            }
        }
    }



})(document, Granite.$);