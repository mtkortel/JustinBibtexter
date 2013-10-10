var justin = (function() {
    // all entries
    es = [];
    // latest query
    q = '';
    // entries filtered by latest query
    fs = [];
    // callbacks
    cbs = [];

    // turn a string into regex that matches against the string
    function escapeRegExp(str) {
        return str.replace(/[\-\[\]\/\{\}\(\)\*\+\?\.\\\^\$\|]/g, '\\$&');
    }
    function icEscRegex(str) {
        return new RegExp(escapeRegExp(str), 'i');
    }

    var jb = function(init) {
        es = init;
        fs = init;
    };

    // there has to be bugs here
    function split(query) {
        words = query.match(/"([^"]|\")*"|([^ "]+("([^"]|\\")*")*)+/g) || [];
        words = words.map(function(word) {
            return word.replace(/([^\\]|^)"/g, '$1');
        });
        words = words.map(function(word) {
            return word.replace(/\\"/g, '"');
        });
        return words;
    }
    function prepareQuery(query) {
        return split(query);
    }

    function matchWord(word, entry) {
        if (word.match(/^@/)) {
            // check entry type
            var r = icEscRegex(word.substring(1));
            if (entry.entryType.typeKey.match(r)) {
                return true;
            }
        } else if (word.match(/^#/)) {
            // check entry key
            var r = icEscRegex(word.substring(1));
            if (entry.entryKey.match(r)) {
                return true;
            }
        } else if (word.match(/([^\\]|^):/)) {
            // key-value
            var key = word.match(/^((\\:)|[^:])*/)[0];
            // ...
            var value = word.match(/([^\\]|^):.*$/g)[0].replace(/[^:]*:/, '');
            key = icEscRegex(key);
            value = icEscRegex(value);
            for (var i = 0; i < entry.fields.length; ++i) {
                var field = entry.fields[i];
                // both must match
                if (field.fieldKey.match(key) &&
                        field.fieldValue.match(value)) {
                    return true;
                }
            }
        } else {
            // search all fields
            var r = icEscRegex(word);
            if (entry.entryType.typeKey.match(r))
                return true;
            if (entry.entryKey.match(r))
                return true;
            for (var i = 0; i < entry.fields.length; ++i) {
                var field = entry.fields[i];
                if (field.fieldKey.match(r))
                    return true;
                if (field.fieldValue.match(r))
                    return true;
            }
        }
        return false;
    }

    // can we compile this with rhino and use it on
    // the server? that's the question...
    function match(query, entry) {

        // all words must match
        for (var i = 0; i < query.length; ++i) {
            if (!matchWord(query[i], entry)) {
                return false;
            }
        }
        return true;
    }

    jb.filtered = function(callback) {
        cbs.push(callback);
        callback(fs);
    };

    jb.filter = function(query) {
        var ret = [];
        q = query;
        query = prepareQuery(query);
        console.log(query);
        es.forEach(function(e) {
            if (match(query, e)) {
                ret.push(e);
            }
        });
        fs = ret;
        cbs.forEach(function(cb) {
            cb(fs);
        });
    };
    return jb;
})();
