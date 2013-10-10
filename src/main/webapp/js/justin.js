var justin = (function() {
    es = [];

    // turn a string into regex that matches against the string
    function escapeRegExp(str) {
        return str.replace(/[\-\[\]\/\{\}\(\)\*\+\?\.\\\^\$\|]/g, "\\$&");
    }

    var jb = function(init) {
        es = init;
    };
    // can we compile this with rhino and use it on
    // the server? that's the question...
    function match(query, entry) {
        query = escapeRegExp(query);
        if (entry.type.search(query) >= 0)
            return true;
        if (entry.key.search(query) >= 0)
            return true;
        for (var i = 0; i < entry.fields.length; ++i) {
            var field = entry.fields[i];
            if (field.key.search(query) >= 0)
                return true;
            if (field.value.search(query) >= 0)
                return true;
        }
        return false;
    }
    jb.filter = function(query, callback) {
        var ret = [];
        es.forEach(function(e) {
            if (match(query, e)) {
                ret.push(e);
            }
        });
        callback(ret);
    };
    return jb;
})();
