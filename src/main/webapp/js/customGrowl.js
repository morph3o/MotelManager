/**
 * PrimeFaces Growl Widget
 */
PrimeFaces.widget.Growl = PrimeFaces.widget.BaseWidget.extend({
    
    init: function(cfg) {
        this.cfg = cfg;
        this.id = this.cfg.id
        this.jqId = PrimeFaces.escapeClientId(this.id);

        this.render();
        
        this.removeScriptElement(this.id);
    },
    
    //Override
    refresh: function(cfg) {
        this.cfg = cfg;
        this.show(cfg.msgs);
        
        this.removeScriptElement(this.id);
    },
    
    show: function(msgs) {
        var _self = this;
        
        this.jq.css('z-index', ++PrimeFaces.zindex);

        //clear previous messages
        this.removeAll();

        $.each(msgs, function(index, msg) {
            _self.renderMessage(msg);
        }); 
    },
    
    removeAll: function() {
        this.jq.children('div.toast').remove();
    },
    
    render: function() {
        //create container
        this.jq = $('<div id="' + this.id + '_container" class="ui-growl ui-widget"></div>');
        this.jq.appendTo($(document.body));

        //render messages
        this.show(this.cfg.msgs);
    },
    
    renderMessage: function(msg) {
        var markup = '<div class="toast toasttext03 growl-severity-' + msg.severity + '" aria-live="polite">';
        markup += '<div class="ui-growl-item">';
        markup += '<button type="button" class="close ui-growl-icon-close"></button>';
        markup += '<div class="toast-body">';
        markup += '<h4 class="toast-title toast-heading"></h4>';
        markup += '<p></p>';
        markup += '</div><div style="clear: both;"></div></div></div>';

        var message = $(markup),
        summaryEL = message.find('h4.toast-title'),
        detailEL = summaryEL.next();
        
        if(this.cfg.escape) {
            summaryEL.text(msg.summary);
            detailEL.text(msg.detail);
        }
        else {
            summaryEL.html(msg.summary);
            detailEL.html(msg.detail);
        }

        this.bindEvents(message);

        message.appendTo(this.jq).fadeIn();
    },
    
    bindEvents: function(message) {
        var _self = this,
        sticky = this.cfg.sticky;

        message.mouseover(function() {
            var msg = $(this);

            //visuals
            if(!msg.is(':animated')) {
                msg.find('button.ui-growl-icon-close:first').show();
            }
        })
        .mouseout(function() {        
            //visuals
            $(this).find('button.ui-growl-icon-close:first').hide();
        });

        //remove message on click of close icon
        message.find('button.ui-growl-icon-close').click(function() {
            _self.removeMessage(message);
            //clear timeout if removed manually
            if(!sticky) {
                clearTimeout(message.data('timeout'));
            }
        });

        //hide the message after given time if not sticky
        if(!sticky) {
            this.setRemovalTimeout(message);
        }
    },
    
    removeMessage: function(message) {
        message.fadeTo('normal', 0, function() {
            message.slideUp('normal', 'easeInOutCirc', function() {
                message.remove();
            });
        });
    },
    
    setRemovalTimeout: function(message) {
        var _self = this;

        var timeout = setTimeout(function() {
            _self.removeMessage(message);
        }, this.cfg.life);

        message.data('timeout', timeout);
    }
});