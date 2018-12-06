package by.grsu.neon.clothesassistant.size;

public enum Size {
    XXS {
        @Override
        public <T> T translate(SizeTranslator<T> translator) {
            return translator.fromXxs();
        }
    },
    XS {
        @Override
        public <T> T translate(SizeTranslator<T> translator) {
            return translator.fromXs();
        }
    },
    S {
        @Override
        public <T> T translate(SizeTranslator<T> translator) {
            return translator.fromS();
        }
    },
    M {
        @Override
        public <T> T translate(SizeTranslator<T> translator) {
            return translator.fromM();
        }
    },
    L {
        @Override
        public <T> T translate(SizeTranslator<T> translator) {
            return translator.fromL();
        }
    },
    XL {
        @Override
        public <T> T translate(SizeTranslator<T> translator) {
            return translator.fromXl();
        }
    },
    XXL {
        @Override
        public <T> T translate(SizeTranslator<T> translator) {
            return translator.fromXxl();
        }
    },
    XXXL {
        @Override
        public <T> T translate(SizeTranslator<T> translator) {
            return translator.fromXxxl();
        }
    },
    XXXXL {
        @Override
        public <T> T translate(SizeTranslator<T> translator) {
            return translator.fromXxxxl();
        }
    };

    public abstract <T> T translate(SizeTranslator<T> translator);
}
